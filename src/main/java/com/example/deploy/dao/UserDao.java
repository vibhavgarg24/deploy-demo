package com.example.deploy.dao;

import com.example.deploy.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserDao extends MongoRepository<User, String> {

    User findByEmail(String email);

    boolean existsByEmail(String email);
}
