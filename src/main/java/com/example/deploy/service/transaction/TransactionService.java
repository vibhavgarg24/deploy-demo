package com.example.deploy.service.transaction;

import com.example.deploy.model.Transaction;

import java.util.List;


public interface TransactionService {

    public Transaction add(Transaction txn);

    public Transaction findById(String txnId);

    public List<Transaction> findByUserId(String userId);

    public List<Transaction> findByCatId(String catId);

    public Transaction update(Transaction txn);

    public Transaction delete(String txnId);
}
