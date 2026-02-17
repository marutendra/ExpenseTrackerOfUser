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
        int currentBalance1 = user.getCurrent_balance();
        if(currentBalance1>0) {
            int currentBalance = user.getCurrent_balance();
            int amount = transaction.getAmount();
            transaction.setBalance(currentBalance - amount);
            user.setCurrent_balance(transaction.getBalance());
            userRepository.save(user);
            int currentBalance2 = user.getCurrent_balance();
            if (currentBalance2 < currentBalance1 && currentBalance2 > 0) {
                transactionRepository.save(transaction);
                return new ResponseEntity<>(HttpStatus.OK);
            }else{

                throw new RuntimeException();

            }
        }else{
            throw new RuntimeException();
        }

    }
public List<Transaction> getall(String id){
       return transactionRepository.findByUserid(id);
}




}
