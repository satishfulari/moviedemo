package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserRatingApplicationTest {
    public static void main(String[] args) { SpringApplication.run(UserRatingApplicationTest.class, args); }
}