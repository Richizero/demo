package com.example.demo.app.users.services;

import com.example.demo.app.users.models.User;
import com.example.demo.app.users.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User>findALL(){
        return userRepository.findAll();
    }

    public User create(User user){
        return userRepository.save(user);
    }
}
