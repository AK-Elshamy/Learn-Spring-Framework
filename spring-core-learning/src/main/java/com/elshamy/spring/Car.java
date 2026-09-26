package com.elshamy.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private final EngineService engineService;

    public Car (EngineService engineService){
        this.engineService = engineService;
        System.out.println("Spring Inject bean first");
    }

    public void drive() {

        engineService.startEngine();
        System.out.println("Car is driving");
    }

    @PostConstruct
    public void init() {
        System.out.println("Car Bean initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Car Bean destroyed");
    }

}