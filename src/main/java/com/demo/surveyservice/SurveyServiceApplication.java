package com.demo.surveyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SurveyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyServiceApplication.class, args);
    }
}
