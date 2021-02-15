package com.codegym.socialnetwork.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_informations")
public class UserInformation {

    @Id
    private Long id;

    private String nickName;
    private String avatarImgUrl;
    private String email;


}
