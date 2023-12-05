package com.example.deploy.service.user;

import com.example.deploy.dao.UserDao;
import com.example.deploy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Override
    public List<User> findAll() {

        return this.userDao.findAll();
    }

    @Override
    public User findById(String id) {

        return this.userDao.findById(id).get();
    }

    @Override
    public String getId(String email) {

        if (this.userDao.existsByEmail(email)) {
            User find = this.userDao.findByEmail(email);
            return find.getId();
        }

        User user = new User(email);
        User save = this.userDao.save(user);
        return save.getId();
    }

    @Override
    public User update(User user) {

        User save = this.userDao.save(user);
        return save;
    }

    @Override
    public User delete(String id) {

        User del = findById(id);
        this.userDao.deleteById(id);
        return del;
    }
}
