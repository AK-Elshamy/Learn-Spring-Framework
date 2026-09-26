package com.elshamy.spring;
import org.springframework.stereotype.Service;

@Service
public class EngineService {

    public void startEngine(){
        System.out.println("Engine Service: starting engine...");
    }
}