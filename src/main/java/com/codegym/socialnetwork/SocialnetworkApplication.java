package com.codegym.socialnetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;

@SpringBootApplication
public class SocialnetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialnetworkApplication.class, args);
    }

}
