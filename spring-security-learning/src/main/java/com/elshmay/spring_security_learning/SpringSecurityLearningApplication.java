package com.elshmay.spring_security_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLearningApplication.class, args);

		PasswordEncoder encoder = new BCryptPasswordEncoder();

		System.out.println("\n\n=================================");
		String hash = encoder.encode("1234");

		System.out.println(hash);
		System.out.println("\n\n=================================");

	}

}
