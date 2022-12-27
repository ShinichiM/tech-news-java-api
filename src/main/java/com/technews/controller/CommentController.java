package com.technews.controller;

import com.technews.model.Comment;
import com.technews.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentRepository repository;

    @GetMapping("/api/comments")
    public List<Comment> getAllComments() {
        List<Comment> commentList = repository.findAll();
        return commentList;
    }

    @GetMapping("/api/comments/{id}")
    public Comment getComment(@PathVariable int id) {
        Comment comment = repository.findById(id).get();
        return comment;
    }

    @PostMapping("/api/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment) {
        return repository.save(comment);
    }

    @PutMapping("/api/updateComment")
    public Comment updateComment(@RequestBody Comment comment) {
        return repository.save(comment);
    }

    @DeleteMapping("/api/comment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {
        repository.deleteById(id);
    }
}
