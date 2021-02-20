package com.codegym.socialnetwork.model.converstation;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conversation")
@Data
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true, length = 64)
    private String image;
    private Long like;
}
