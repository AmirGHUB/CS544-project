package edu.miu.cs544.team6.controller;

import edu.miu.cs544.team6.domain.User;
import edu.miu.cs544.team6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

}
