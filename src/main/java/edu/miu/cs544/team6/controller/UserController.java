package edu.miu.cs544.team6.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.team6.domain.User;
import edu.miu.cs544.team6.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;



	@PostMapping()
	public void createUser(@RequestBody User user) {
		userService.save(user);
	}

	@GetMapping()
	public List<User> getUsers() {
		return userService.findAll();
	}

	@GetMapping("/{userid}")
	public User getUserById(@PathVariable int userid) {
		return userService.findById(userid);
	}

	@PutMapping("/{userid}")
	public User updateById(@PathVariable int userid, @RequestBody User user) {
		User u = userService.findById(userid);
		if (u == null) return null;
		user.setId(userid);
		return userService.update(user);
	}

	@DeleteMapping("/{userid}")
	public void deleteUser(@PathVariable int userid) {
		userService.delete(userid);
	}


}
