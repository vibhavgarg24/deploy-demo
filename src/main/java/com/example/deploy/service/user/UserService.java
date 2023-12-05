package com.example.deploy.service.user;

import com.example.deploy.model.User;

import java.util.List;


public interface UserService {

    public List<User> findAll();

    public User findById(String id);

    public String getId(String email);

    public User update(User user);

    public User delete(String id);
}
