package com.codegym.socialnetwork.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_role")
public class Role {

    @Id
    private Long id;
    private String user_role;

    @OneToMany(targetEntity = User.class)
    private Set<User> user;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
