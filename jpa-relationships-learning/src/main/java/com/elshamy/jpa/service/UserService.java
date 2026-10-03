package com.elshamy.jpa.service;

import com.elshamy.jpa.model.*;
import com.elshamy.jpa.repository.ProfileRepository;
import com.elshamy.jpa.repository.UserRepository;
import com.elshamy.jpa.specification.UserSpecification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public UserService(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
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

    public void testDerivedMethod() {

        System.out.println("=== findByName ===");
        userRepository.findByName("Ahmed")
                .forEach(user ->
                        System.out.println(user.getId() + " -> " + user.getName())
                );

        System.out.println("=== findByNameContaining ===");
        userRepository.findByNameContaining("ah")
                .forEach(user ->
                        System.out.println(user.getId() + " -> " + user.getName())
                );
    }


    public void getUsers(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<User> userPage =   userRepository.findAll(pageable);
        System.out.println("Users: ");
        userPage.stream().forEach(user -> {
            System.out.println(user.getId() + " -> " + user.getName());
        });
        System.out.println("Total: " + userPage.getTotalElements());
        System.out.println("Pages: " + userPage.getTotalPages());
        System.out.println("Current: " + userPage.getNumber());
        System.out.println("Has next: " + userPage.hasNext());
    }

    public void testSpecification() {

        Specification<User> specification =
                UserSpecification.nameContains("ah");

        Pageable pageable =
                PageRequest.of(
                        0,
                        5,
                        Sort.by("name").ascending()
                );

        Page<User> users =
                userRepository.findAll(
                        specification,
                        pageable
                );

        users.forEach(user ->
                System.out.println(
                        user.getId() + " -> " + user.getName()
                )
        );
    }


}