package com.example.deploy.controller;

import com.example.deploy.model.Transaction;
import com.example.deploy.service.transaction.TransactionService;
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
@RequestMapping("/txn")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public TransactionController() {
    }

    @PostMapping("/add")
    public ResponseEntity<Transaction> add(@RequestBody Transaction txn) {

        Transaction addedTxn = this.transactionService.add(txn);
        return new ResponseEntity<Transaction>(addedTxn, HttpStatus.OK);
    }

    @GetMapping("/findById/{txnId}")
    public ResponseEntity<Transaction> findById(@PathVariable String txnId) {

        Transaction txn = this.transactionService.findById(txnId);
        return new ResponseEntity<Transaction>(txn, HttpStatus.OK);
    }

    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<List<Transaction>> findByUserId(@PathVariable String userId) {

        List<Transaction> list = this.transactionService.findByUserId(userId);
        return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
    }

    @GetMapping("/findByCatId/{catId}")
    public ResponseEntity<List<Transaction>> findByCatId(@PathVariable String catId) {

        List<Transaction> list = this.transactionService.findByCatId(catId);
        return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Transaction> update(@RequestBody Transaction txn) {

        Transaction updatedTxn = this.transactionService.update(txn);
        return new ResponseEntity<Transaction>(updatedTxn, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{txnId}")
    public ResponseEntity<Transaction> delete(@PathVariable String txnId) {

        Transaction deletedTxn = this.transactionService.delete(txnId);
        return new ResponseEntity<Transaction>(deletedTxn, HttpStatus.OK);
    }

}
