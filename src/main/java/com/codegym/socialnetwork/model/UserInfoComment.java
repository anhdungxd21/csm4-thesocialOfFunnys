package com.codegym.socialnetwork.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_info_comment")
@Data
public class UserInfoComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String userCommentName;
    private String comment;
}
