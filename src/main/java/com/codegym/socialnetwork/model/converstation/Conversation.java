package com.codegym.socialnetwork.model.converstation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long like;
    private Long dislike;

    @OneToMany(targetEntity = Comment.class)
    private List<Comment> comment;
}
