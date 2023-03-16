package com.codercampus.Assignment11.service;


import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository ;

    public List<Transaction> findAll() {return transactionRepository.findAll();}

    public List<Transaction> findAllSorted() {
        List<Transaction> sortedList = transactionRepository.findAll();
        Collections.sort(sortedList);
        return sortedList;
    }

    public Transaction findById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId);
        return transaction;
    }

}
