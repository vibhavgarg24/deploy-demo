package com.example.deploy.dao;

import com.example.deploy.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface CategoryDao extends MongoRepository<Category, String> {

    boolean existsByUserIdAndName(String userId, String name);

    List<Category> findByUserId(String userId);

    Optional<Category> findById(String id);

}
