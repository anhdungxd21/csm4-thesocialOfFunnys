package com.codegym.socialnetwork.model.converstation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    private Long id;
    private int user_id;
    private String context;
}
