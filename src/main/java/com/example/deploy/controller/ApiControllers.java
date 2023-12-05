package com.example.deploy.controller;

import com.example.deploy.model.Test;
import com.example.deploy.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class ApiControllers {

    @Autowired
    private TestService testService;

    @GetMapping("")
    public String welcome() {

        return "Welcome to Greyworm!";
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        return this.testService.findAll();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {

        return this.testService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Test test) {

        return this.testService.add(test);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Test test) {

        return this.testService.update(test);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        return this.testService.delete(id);
    }

    @GetMapping("/findByKey/{key}")
    public ResponseEntity<?> findByKey(@PathVariable int key) {

        return this.testService.findByKey(key);
    }

    @GetMapping("/existsByKey/{key}")
    public ResponseEntity<?> existsByKey(@PathVariable int key) {

        return this.testService.existsByKey(key);
    }

    @GetMapping("/getIdByKey/{key}")
    public ResponseEntity<?> getIdByKey(@PathVariable int key) {

        return this.testService.getIdByKey(key);
    }
}
