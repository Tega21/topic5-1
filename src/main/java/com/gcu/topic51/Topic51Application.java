package com.gcu.topic51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan({"com.gcu"})
@SpringBootApplication
@EnableMongoRepositories("com.gcu.data.repository")
public class Topic51Application {

    public static void main(String[] args) {
        SpringApplication.run(Topic51Application.class, args);
    }
}