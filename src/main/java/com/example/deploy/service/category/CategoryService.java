package com.example.deploy.service.category;

import com.example.deploy.model.Category;

import java.util.List;


public interface CategoryService {

    public Category add(String userId, String categoryName);

    public List<Category> findByUserId(String userId);

    public Category findById(String catId);

    public Category update(Category category);

    public Category delete(String catId);

    public Category reset(String catId);
}
