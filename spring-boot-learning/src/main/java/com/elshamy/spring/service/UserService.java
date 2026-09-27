package com.elshamy.spring.service;

import com.elshamy.spring.model.User;
import com.elshamy.spring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        Optional<User> savedUser = userRepository.findById(user.getId());

        if(savedUser.isEmpty()){
            return null;
        }

        User updatedUser = savedUser.get();

        updatedUser.setAge(user.getAge());
        updatedUser.setName(user.getName());
        return userRepository.save(updatedUser);
    }

    public boolean deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            return false;
        }

        userRepository.deleteById(id);
        return true;
    }
}
