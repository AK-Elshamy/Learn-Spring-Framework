package com.elshamy.spring;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public void save(){
        System.out.println("Saving user to database...");
    }
}
