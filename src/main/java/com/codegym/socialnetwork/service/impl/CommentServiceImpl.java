package com.codegym.socialnetwork.service.impl;

import com.codegym.socialnetwork.model.Comment;
import com.codegym.socialnetwork.repository.conversation.CommentRepository;
import com.codegym.socialnetwork.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Iterable<Comment> findAllByConversationId(Long id){
        return commentRepository.findAllByConversationId(id);
    }

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }
}
