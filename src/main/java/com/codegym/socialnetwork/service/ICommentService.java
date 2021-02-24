package com.codegym.socialnetwork.service;

import com.codegym.socialnetwork.model.Comment;

public interface ICommentService extends GeneralService<Comment>{
    public Iterable<Comment> findAllByConversationId(Long id);
}
