package com.example.deploy.service.transaction;

import com.example.deploy.dao.CategoryDao;
import com.example.deploy.dao.TxnDao;
import com.example.deploy.dao.UserDao;
import com.example.deploy.exception.InvalidInputException;
import com.example.deploy.model.Category;
import com.example.deploy.model.Transaction;
import com.example.deploy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TxnDao txnDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Transaction add(Transaction txn) {

        if (txn.getAmount() < 0) {
            throw new InvalidInputException("103", "Invalid inputs");
        }

        double amount = txn.getAmount();

        // add amount to user total
        User user = this.userDao.findById(txn.getUserId()).get();
        user.setTotalSum(user.getTotalSum() + amount);
        this.userDao.save(user);

        // add amount to category total
        Category category = this.categoryDao.findById(txn.getCatId()).get();
        category.setSum(category.getSum() + amount);
        this.categoryDao.save(category);

        // add txn to db
        Transaction save = this.txnDao.save(txn);
        return save;
    }

    @Override
    public Transaction findById(String txnId) {

        return this.txnDao.findById(txnId).get();
    }

    @Override
    public List<Transaction> findByUserId(String userId) {

        return this.txnDao.findByUserId(userId);
    }

    @Override
    public List<Transaction> findByCatId(String catId) {

        return this.txnDao.findByCatId(catId);
    }

    @Override
    public Transaction update(Transaction txn) {

        Transaction deletedTxn = delete(txn.getId());
        try {
            add(txn);
        } catch (Exception e) {
            add(deletedTxn);
            throw e;
        }

        return txn;
    }

    @Override
    public Transaction delete(String txnId) {

        Transaction txn = findById(txnId);

        double amount = txn.getAmount();

        // sub amount from user total
        User user = this.userDao.findById(txn.getUserId()).get();
        user.setTotalSum(user.getTotalSum() - amount);
        this.userDao.save(user);

        // sub amount from category total
        Category category = this.categoryDao.findById(txn.getCatId()).get();
        category.setSum(category.getSum() - amount);
        this.categoryDao.save(category);

        // delete txn from db
        this.txnDao.deleteById(txnId);
        return txn;
    }

}
