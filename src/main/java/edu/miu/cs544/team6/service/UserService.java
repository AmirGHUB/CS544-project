package edu.miu.cs544.team6.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.team6.domain.User;
import edu.miu.cs544.team6.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void save(User user) {
		
		userRepository.save(user);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(int userid) {
		Optional<User> user = userRepository.findById(userid);
		return user.isPresent() ? user.get(): null; 
	}
	
	public User update(int userId) {
		User oldUser = findById(userId);
    	if(oldUser == null){
    		return null;
    	}
    	return userRepository.save(oldUser);
	}
	
	public void delete(int userId) {
		User oldUser = findById(userId);
    	if(oldUser == null){
    		return;
    	}
		userRepository.deleteById(userId);
	}

}
