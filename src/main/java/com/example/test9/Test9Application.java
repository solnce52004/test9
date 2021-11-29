package com.example.test9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableR2dbcRepositories("com.example.test9.repo")
public class Test9Application {

    public static void main(String[] args) {
        SpringApplication.run(Test9Application.class, args);
    }

}
