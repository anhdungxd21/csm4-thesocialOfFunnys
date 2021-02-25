package com.codegym.socialnetwork.service;

import com.codegym.socialnetwork.model.UserInfoComment;

import java.util.List;

public interface IUserInfoCommentService extends GeneralService<UserInfoComment>{
    List<UserInfoComment> findAllByUsername(String username);
}
