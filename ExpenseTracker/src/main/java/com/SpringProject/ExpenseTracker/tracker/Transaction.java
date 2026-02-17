package com.SpringProject.ExpenseTracker.tracker;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "Transaction")
@Data
public class Transaction {
    @Id
    String id;
    String userid;
    String type;
    LocalDateTime time;
    int amount;
    String title;
    int balance;



}
