package com.example.kiethuynh.services;

import com.example.kiethuynh.entity.User;
import com.example.kiethuynh.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public  void save (User user){
        userRepository.save(user);
    }
}
