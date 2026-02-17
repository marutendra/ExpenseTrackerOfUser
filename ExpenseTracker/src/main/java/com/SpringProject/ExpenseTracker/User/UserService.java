package com.SpringProject.ExpenseTracker.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveuser(User user){
        return userRepository.save(user);
    }


    public User updateuser(String username , User user){
        User byUsername = userRepository.findByUsername(username);
        byUsername.setUsername(user.getUsername());
        byUsername.setPassword(user.getPassword());
        return userRepository.save(byUsername);

    }



}
