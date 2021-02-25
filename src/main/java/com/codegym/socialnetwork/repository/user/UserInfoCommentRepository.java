package com.codegym.socialnetwork.repository.user;

import com.codegym.socialnetwork.model.UserInfoComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserInfoCommentRepository extends CrudRepository<UserInfoComment, Long> {
    List<UserInfoComment> findAllByUsername(String username);
}
