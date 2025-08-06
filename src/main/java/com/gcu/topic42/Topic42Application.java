package com.gcu.topic42;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@ComponentScan({"com.gcu"})
@SpringBootApplication
@EnableJdbcRepositories("com.gcu.data.repository")
public class Topic42Application {

    public static void main(String[] args) {
        SpringApplication.run(Topic42Application.class, args);
    }
}