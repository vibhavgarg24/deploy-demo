package com.example.deploy.service.category;

import com.example.deploy.dao.CategoryDao;
import com.example.deploy.dao.TxnDao;
import com.example.deploy.dao.UserDao;
import com.example.deploy.exception.DuplicateException;
import com.example.deploy.exception.EmptyException;
import com.example.deploy.model.Category;
import com.example.deploy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TxnDao txnDao;

    @Override
    public Category add(String userId, String categoryName) {

        if (categoryName.trim().equals("")) {
            throw new EmptyException("102", "Category name empty");
        }

        if (this.categoryDao.existsByUserIdAndName(userId, categoryName)) {
            throw new DuplicateException("101", "Duplicate category name");
        }

        Category category = new Category(userId, categoryName);
        Category save = this.categoryDao.save(category);
        return save;
    }

    @Override
    public List<Category> findByUserId(String userId) {

        return this.categoryDao.findByUserId(userId);
    }

    @Override
    public Category findById(String catId) {

        return this.categoryDao.findById(catId).get();
    }

    @Override
    public Category update(Category category) {

        Category save = this.categoryDao.save(category);
        return save;
    }

    @Override
    public Category delete(String catId) {

        // delete all txns of this category
        this.txnDao.deleteAllByCatId(catId);

        Category del = findById(catId);

        // sub cat sum from user total
        User user = this.userDao.findById(del.getUserId()).get();
        user.setTotalSum(user.getTotalSum() - del.getSum());
        this.userDao.save(user);

        this.categoryDao.deleteById(catId);
        return del;
    }

    @Override
    public Category reset(String catId) {

        // delete all txns of this category
        this.txnDao.deleteAllByCatId(catId);

        Category reset = findById(catId);

        // sub cat sum from user total
        User user = this.userDao.findById(reset.getUserId()).get();
        user.setTotalSum(user.getTotalSum() - reset.getSum());
        this.userDao.save(user);

        //category sum zero
        reset.setSum(0);
        Category save = this.categoryDao.save(reset);

        return save;
    }

}