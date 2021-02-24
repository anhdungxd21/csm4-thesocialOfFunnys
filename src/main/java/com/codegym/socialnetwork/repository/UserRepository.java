package com.codegym.socialnetwork.repository;

import com.codegym.socialnetwork.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

}