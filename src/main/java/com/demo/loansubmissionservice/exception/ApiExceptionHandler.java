/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.loansubmissionservice.exception;

import com.demo.loansubmissionservice.dto.ApiException;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Steven Raylianto K.
 */

@ControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(value = {MyRestTemplateException.class})
    public ResponseEntity<Object> handleApiRequestExcption(MyRestTemplateException e) {
        ApiException exception = new ApiException(
                LocalDateTime.now(),
                e.getStatus(),
                e.getMessage(),
                e.getThrowable()
        );
        
        return new ResponseEntity<>(exception, e.getStatus());
    };
    
    @ExceptionHandler(value = {MyResourceException.class})
    public ResponseEntity<Object> handleApiRequestExcption(MyResourceException e) {
        HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiException exception = new ApiException(
                LocalDateTime.now(),
                badRequest,
                e.getMessage(),
                e
        );
        
        return new ResponseEntity<>(exception, badRequest);
    }; 
}
