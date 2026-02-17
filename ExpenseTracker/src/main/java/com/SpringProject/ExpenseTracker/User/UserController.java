package com.SpringProject.ExpenseTracker.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public User save(@RequestBody User user){
        return userService.saveuser(user);
    }

    @PutMapping("/username/{username}")
    public User update(@PathVariable String username , @RequestBody User user){
        return userService.updateuser(username,user);
    }



}
