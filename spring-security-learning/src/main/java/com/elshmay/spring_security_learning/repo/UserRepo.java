package com.elshmay.spring_security_learning.repo;

import com.elshmay.spring_security_learning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
