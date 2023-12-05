package com.example.deploy.dao;

import com.example.deploy.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface TxnDao extends MongoRepository<Transaction, String> {

    List<Transaction> findByUserId(String userId);

    List<Transaction> findByCatId(String catId);

    void deleteAllByCatId(String catId);

}
