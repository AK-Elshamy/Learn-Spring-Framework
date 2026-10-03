package com.elshamy.jpa;

import com.elshamy.jpa.model.Course;
import com.elshamy.jpa.model.Post;
import com.elshamy.jpa.model.Profile;
import com.elshamy.jpa.model.User;
import com.elshamy.jpa.repository.ProfileRepository;
import com.elshamy.jpa.repository.UserRepository;
import com.elshamy.jpa.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class JpaRelationshipsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaRelationshipsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(
            UserService userService,
            UserRepository userRepository
    ) {
        return args -> {

            System.out.println("\n\n");
            userService.testSpecification();
        };
    }
}