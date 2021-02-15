package com.codegym.socialnetwork.model.converstation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true, length = 64)
    private String image;
    private Long like;
    private Long dislike;

//    @OneToMany(targetEntity = Comment.class)
//    private List<Comment> comment;

    public Conversation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    public Long getDislike() {
        return dislike;
    }

    public void setDislike(Long dislike) {
        this.dislike = dislike;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //    public List<Comment> getComment() {
//        return comment;
//    }
//
//    public void setComment(List<Comment> comment) {
//        this.comment = comment;
//    }
}
