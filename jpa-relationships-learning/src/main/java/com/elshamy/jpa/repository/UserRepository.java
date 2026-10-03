package com.elshamy.jpa.repository;

import com.elshamy.jpa.model.Post;
import com.elshamy.jpa.model.User;
import com.elshamy.jpa.model.UserDTO;
import com.elshamy.jpa.model.UserSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    List<User> findByNameContaining(String name);
    List<User> findByName(String name);


}