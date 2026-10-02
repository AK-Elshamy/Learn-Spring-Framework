package com.elshamy.jpa.service;

import com.elshamy.jpa.model.Post;
import com.elshamy.jpa.model.User;
import com.elshamy.jpa.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void testMerge(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        entityManager.remove(user);
    }
    @Transactional
    public void testOrphanRemoval(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        user.setProfile(null);
    }
    public void testJPQL(Long userId){
        List<Post> posts = userRepository.findPostsByUserId(userId);
        posts.stream().forEach(post -> System.out.println(post.getTitle()));
    }
}