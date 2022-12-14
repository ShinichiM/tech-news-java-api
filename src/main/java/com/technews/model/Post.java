package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
//import javax.xml.stream.events.Comment;
import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Objects;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="post")
public class Post implements Serializable{
// @Id signals that id will be used as a unique identifier
// @GeneratedValue denotes that id will be a generated value, given input parameter strategy = GenerationType.AUTO
// @Transient signals to Spring data JPA that this data (loggedIn) is not to be persisted in the DB.
// @NotNull signales to Spring DATA JPA that vairable is not allowed to be null in DB
// @Temporal allows us to use type Date in DB and signals JPA these fields house data of type DATE
// @Column designates the name of the column for the DB
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String postUrl;

    @Transient
    private String userName;

    @Transient
    private int voteCount;
    private Integer userId;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name="posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name="updated_at")
    private Date updatedAt = new Date();

    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    public Post(Integer id, String title, String postUrl, int voteCount, Integer userId) {
        this.id = id;
        this.title = title;
        this.postUrl = postUrl;
        this.voteCount = voteCount;
        this.userId = userId;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPostUrl() {
        return postUrl;
    }
    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }
    public int getVoteCount() {
        return voteCount;
    }
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Date getPostedAt() {
        return postedAt;
    }
    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return getVoteCount() == post.getVoteCount() && Objects.equals(getId(), post.getId()) && Objects.equals(getTitle(), post.getTitle()) && Objects.equals(getPostUrl(), post.getPostUrl()) && Objects.equals(getUserName(), post.getUserName()) && Objects.equals(getUserId(), post.getUserId()) && Objects.equals(getPostedAt(), post.getPostedAt()) && Objects.equals(getUpdatedAt(), post.getUpdatedAt()) && Objects.equals(getComments(), post.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPostUrl(), getUserName(), getVoteCount(), getUserId(), getPostedAt(), getUpdatedAt(), getComments());
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", voteCount=" + voteCount +
                ", userId=" + userId +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                '}';
    }
}
