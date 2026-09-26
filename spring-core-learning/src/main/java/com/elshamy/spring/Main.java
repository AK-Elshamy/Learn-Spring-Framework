package com.elshamy.spring;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "com.elshamy.spring"
                );

        Car car = context.getBean(Car.class);
        car.drive();
        context.close();
    }
}