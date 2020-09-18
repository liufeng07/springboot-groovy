package com.conlin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:spring-groovy.xml"})
public class GroovyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroovyApplication.class, args);
    }
}
