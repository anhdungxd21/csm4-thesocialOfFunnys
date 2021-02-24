package com.codegym.socialnetwork.repository.conversation;

import com.codegym.socialnetwork.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
