package edu.miu.cs544.team6.service.impl;

import edu.miu.cs544.team6.domain.User;
import edu.miu.cs544.team6.repository.UserRepository;
import edu.miu.cs544.team6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
