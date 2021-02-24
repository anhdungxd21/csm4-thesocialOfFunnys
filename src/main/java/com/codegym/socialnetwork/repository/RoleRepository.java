package com.codegym.socialnetwork.repository;

import com.codegym.socialnetwork.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);

}