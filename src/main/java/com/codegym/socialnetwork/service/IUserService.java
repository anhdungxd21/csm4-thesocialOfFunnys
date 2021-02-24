package com.codegym.socialnetwork.service;

import com.codegym.socialnetwork.model.User;

import java.util.Optional;

public interface IUserService extends GeneralService<User>{
    User findUserByUsername(String name);
    User getCurrentUser();
}
