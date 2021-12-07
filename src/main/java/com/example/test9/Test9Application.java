package com.example.test9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EntityScan(basePackages = {"com.example.test9.entity"})
//@EnableR2dbcRepositories("com.example.test9.repo")
@EnableReactiveMongoRepositories(basePackages = {"com.example.test9.repo"})  //////

public class Test9Application {

    public static void main(String[] args) {
        SpringApplication.run(Test9Application.class, args);
    }

}
