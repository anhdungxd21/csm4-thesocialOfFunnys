package com.codegym.socialnetwork.model.converstation;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    private Long id;
    private int user_id;
    private String context;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Conversation conversation;


    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
