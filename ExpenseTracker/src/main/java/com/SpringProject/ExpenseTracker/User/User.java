package com.SpringProject.ExpenseTracker.User;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "userdata")
@Data
public class User {
    @Id
    String id;
    @Indexed(unique = true)
    @NonNull
    String username;
    @NonNull
    String password;
    int current_balance;


}
