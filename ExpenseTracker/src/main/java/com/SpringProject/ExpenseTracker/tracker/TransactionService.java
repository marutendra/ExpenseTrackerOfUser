package com.SpringProject.ExpenseTracker.tracker;

import com.SpringProject.ExpenseTracker.User.User;
import com.SpringProject.ExpenseTracker.User.UserRepository;
import com.mongodb.internal.connection.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
   @Autowired
    UserRepository userRepository;


@Transactional
    public ResponseEntity<Transaction> save(String id , Transaction transaction) {
    User user = userRepository.findById(id).orElse(null);
    transaction.setUserid(id);
    transaction.setTime(LocalDateTime.now());
    int currentBalance = user.getCurrent_balance();
    int amount = transaction.getAmount();
    if(amount>currentBalance){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    else {
        user.setCurrent_balance(currentBalance - amount);
        userRepository.save(user);
        int currentBalance1 = user.getCurrent_balance();
        transaction.setBalance(currentBalance1);
        transactionRepository.save(transaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }




    }
public List<Transaction> getall(String id){
       return transactionRepository.findByUserid(id);
}




}
