package edu.miu.cs544.team6.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import edu.miu.cs544.team6.domain.User;
import edu.miu.cs544.team6.dto.UserDTO;
import edu.miu.cs544.team6.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping()
    public void createUser(@RequestBody User user) {
    	userService.save(user);
    }
    
    @GetMapping()
    public List<UserDTO> getUsers(){
    	return userService.findAll().stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{userid}")
    public User getUserById(@PathVariable int userid) {
    	return userService.findById(userid);
    }
    
    @PostMapping("/{userid}")
    public User updateById(@PathVariable int userid) {
    	return userService.update(userid);
    }
    
    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable int userid) {
    	userService.delete(userid);
    }
    
    /** from system to user Map to UserDto**/
    private UserDTO convertToUserDTO(User user) {  
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);  
        return userDTO;
    }
    
    
}
