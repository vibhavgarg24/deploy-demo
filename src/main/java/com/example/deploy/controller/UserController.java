package com.example.deploy.controller;

import com.example.deploy.model.User;
import com.example.deploy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {

        List<User> list = this.userService.findAll();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {

        User user = this.userService.findById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // Used for adding new User as well
    @GetMapping("/getId/{email}")
    public ResponseEntity<String> getId(@PathVariable String email) {

        String id = this.userService.getId(email);
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {

        User updatedUser = this.userService.update(user);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable String id) {

        User deletedUser = this.userService.delete(id);
        return new ResponseEntity<User>(deletedUser, HttpStatus.OK);
    }
}
