package com.elshamy.jpa.repository;

import com.elshamy.jpa.model.Post;
import com.elshamy.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
    SELECT p
    FROM Post p
    WHERE p.user.id = :userId
""")
    List<Post> findPostsByUserId(@Param("userId") Long userId);
}