package com.example.deploy.controller;

import com.example.deploy.model.Category;
import com.example.deploy.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController() {
    }

    @PostMapping("/add/{userId}/{categoryName}")
    public ResponseEntity<Category> add(@PathVariable String userId, @PathVariable String categoryName) {

        Category addedCategory = this.categoryService.add(userId, categoryName);
        return new ResponseEntity<Category>(addedCategory, HttpStatus.OK);
    }

    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<List<Category>> findByUserId(@PathVariable String userId) {

        List<Category> list = this.categoryService.findByUserId(userId);
        return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
    }

    @GetMapping("/findById/{catId}")
    public ResponseEntity<Category> findById(@PathVariable String catId) {

        Category category = this.categoryService.findById(catId);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category) {

        Category updatedCategory = this.categoryService.update(category);
        return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{catId}")
    public ResponseEntity<Category> delete(@PathVariable String catId) {

        Category deletedCategory = this.categoryService.delete(catId);
        return new ResponseEntity<Category>(deletedCategory, HttpStatus.OK);
    }

    @DeleteMapping("reset/{catId}")
    public ResponseEntity<Category> reset(@PathVariable String catId) {

        Category resetCategory = this.categoryService.reset(catId);
        return new ResponseEntity<Category>(resetCategory, HttpStatus.OK);
    }
}
