package com.codegym.socialnetwork.model.converstation;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    private Long id;
    private Long conversationId;
    private int user_id;
    private String context;
}
