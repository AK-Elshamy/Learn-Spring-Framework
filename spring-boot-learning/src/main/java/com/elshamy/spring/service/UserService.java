package com.elshamy.spring.service;

import com.elshamy.spring.dto.UserRequestDTO;
import com.elshamy.spring.dto.UserResponseDTO;
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

    public List<UserResponseDTO> getUsers(){
        return userRepository.findAll()
                .stream().map(this::toUserResponseDTO)
                .toList();
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        User user = toUser(userRequestDTO);
        return toUserResponseDTO(userRepository.save(user));
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO){
        Optional<User> savedUser = userRepository.findById(id);

        if(savedUser.isEmpty()){
            return null;
        }

        User updatedUser = savedUser.get();

        updatedUser.setName(userRequestDTO.name());
        updatedUser.setAge(userRequestDTO.age());
        return toUserResponseDTO(userRepository.save(updatedUser));
    }

    public boolean deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            return false;
        }

        userRepository.deleteById(id);
        return true;
    }

    private UserResponseDTO toUserResponseDTO(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getAge()
        );
    }
    private User toUser(UserRequestDTO userRequestDTO){
        return new User(userRequestDTO.name(), userRequestDTO.age());
    }
}
