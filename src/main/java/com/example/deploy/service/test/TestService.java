package com.example.deploy.service.test;

import com.example.deploy.model.Test;
import org.springframework.http.ResponseEntity;


public interface TestService {

    public ResponseEntity<?> findAll();

    public ResponseEntity<?> findById(String id);

    public ResponseEntity<?> add(Test test);

    public ResponseEntity<?> update(Test test);

    public ResponseEntity<?> delete(String id);

    public ResponseEntity<?> findByKey(int key);

    public ResponseEntity<?> existsByKey(int key);

    public ResponseEntity<?> getIdByKey(int key);
}
