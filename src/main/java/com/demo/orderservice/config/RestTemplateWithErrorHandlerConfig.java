/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.orderservice.config;

import com.demo.orderservice.exception.CustomResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author Steven Raylianto K.
 */
@Configuration
public class RestTemplateWithErrorHandlerConfig {

    @Bean
    RestTemplate restTemplateWithErrorHandler() {
        return new RestTemplateBuilder()
                .errorHandler(new CustomResponseErrorHandler())
                .build();
    }
}
