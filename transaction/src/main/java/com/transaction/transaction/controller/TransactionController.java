package com.transaction.transaction.controller;

import com.transaction.transaction.DTO.UserDTO;
import com.transaction.transaction.entity.Transaction;
import com.transaction.transaction.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public List<Transaction> findAll(){
        return transactionService.findAll();
    }
    @GetMapping("/{id}")
    public Transaction findById(@PathVariable Long id){
        return transactionService.findById(id);
    }
    @PostMapping("/new")
    public Transaction save(@RequestBody Transaction transaction){
        return transactionService.save(transaction);
    }
//    @GetMapping("/user/{id}")
//    public UserDTO findUserById(@PathVariable Long id){
//        return transactionService.findUserById(id);
//    }
}
