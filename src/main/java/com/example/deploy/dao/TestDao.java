package com.example.deploy.dao;

import com.example.deploy.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TestDao extends MongoRepository<Test, String> {

    Test findByKey(int key);

    boolean existsByKey(int key);

}
