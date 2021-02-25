package com.codegym.socialnetwork.service.impl;

import com.codegym.socialnetwork.model.UserInfoComment;
import com.codegym.socialnetwork.repository.user.UserInfoCommentRepository;
import com.codegym.socialnetwork.service.IUserInfoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoServiceImpl implements IUserInfoCommentService {

    @Autowired
    private UserInfoCommentRepository userInfoCommentRepository;

    @Override
    public List<UserInfoComment> findAllByUsername(String username) {
        return userInfoCommentRepository.findAllByUsername(username);
    }

    @Override
    public Iterable<UserInfoComment> findAll() {
        return userInfoCommentRepository.findAll();
    }

    @Override
    public Optional<UserInfoComment> findById(Long id) {
        return userInfoCommentRepository.findById(id);
    }

    @Override
    public UserInfoComment save(UserInfoComment userInfoComment) {
        return userInfoCommentRepository.save(userInfoComment);
    }

    @Override
    public void remove(Long id) {
        userInfoCommentRepository.deleteById(id);
    }
}
