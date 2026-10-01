package com.elshamy.jpa;

import com.elshamy.jpa.model.Course;
import com.elshamy.jpa.model.Post;
import com.elshamy.jpa.model.Profile;
import com.elshamy.jpa.model.User;
import com.elshamy.jpa.repository.ProfileRepository;
import com.elshamy.jpa.repository.UserRepository;
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
            UserRepository userRepository,
            ProfileRepository profileRepository
    ) {
        return args -> {

            User abdo = new User("Abdulrhman");
            abdo.setProfile(new Profile("Abdo Profile"));
            Course course = new Course("JAVA BackEnd");
            abdo.addCourse(course);
            Post post = new Post("Post #1");
            abdo.addPost(post);
            userRepository.save(abdo);
        };
    }
}