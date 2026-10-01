package com.elshamy.jpa;

import com.elshamy.jpa.model.Profile;
import com.elshamy.jpa.model.User;
import com.elshamy.jpa.repository.ProfileRepository;
import com.elshamy.jpa.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

            Profile profile =
                    new Profile("Software Engineering");



            User user =
                    new User("Mohamed");

            user.setProfile(profile);

            userRepository.save(user);
        };
    }
}