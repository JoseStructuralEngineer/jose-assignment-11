package com.codercampus.Assignment11.web;


import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public String getPeople (ModelMap model) {
        //   This is what gets returned / resolved when we
        //     return a String inside of a regular Controller GetMapping method
        //   /src/main/resources/templates/welcome.html
        List<Transaction> transactions = transactionService.findAllSorted();

        model.put("transactionsAll",transactions);

        return "transactions";
    }

    @GetMapping("/transactions/{transactionId}")
    public String getPeople2 (@PathVariable Long transactionId,ModelMap model) {
        //   This is what gets returned / resolved when we
        //     return a String inside of a regular Controller GetMapping method
        //   /src/main/resources/templates/welcome.html


        Transaction transaction = transactionService.findById(transactionId);

        model.put("transactionsIndividual",transaction);

        return "individualtransaction";
    }

}
