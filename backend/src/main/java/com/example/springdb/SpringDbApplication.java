package com.example.springdb;

import com.example.springdb.model.User;
import com.example.springdb.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDbApplication.class, args);
    }

}
