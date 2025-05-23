package com.example.spum_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpumBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpumBackendApplication.class, args);
    }

}
