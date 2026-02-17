package com.SpringProject.ExpenseTracker.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/userid/{userID}")
    public ResponseEntity<Transaction> save(@PathVariable String userID , @RequestBody Transaction transaction){
        return transactionService.save(userID,transaction);
    }

    @GetMapping("id/{id}")
    public List<Transaction> get(@PathVariable String id){
        return transactionService.getall(id);
    }


}
