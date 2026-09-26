package com.elshamy.spring;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(){
        System.out.println("UserService: creating user...");
        userRepository.save();
    }
}
