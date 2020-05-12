package edu.miu.cs544.team6.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.team6.domain.User;
import edu.miu.cs544.team6.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping()
    public void createUser(@RequestBody User user) {
    	userService.save(user);
    }
    
    @GetMapping()
    public List<User> getUsers(){
    	return userService.findAll();
    }
    
    @GetMapping("/{userid}")
    public User getUserById(@PathVariable int userid) {
    	return userService.findById(userid);
    }
    
    @PostMapping("/{userid}")
    public User updateById(@PathVariable int userid, @RequestBody Map<String, String>password) {
    	return userService.update(userid, password.get("password"));
    }
    
    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable int userid) {
    	userService.delete(userid);
    }

}
