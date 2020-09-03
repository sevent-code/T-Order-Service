/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.loansubmissionservice.service;

import com.demo.loansubmissionservice.model.LoanSubmission;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Steven Raylianto K.
 */
public interface LoanSubmissionService {
    LoanSubmission createOrder(LoanSubmission order);
    LoanSubmission updateOrder(Long id, LoanSubmission orderRequest);
    ResponseEntity<?> deleteOrder(Long id);
    List<LoanSubmission> getOrders(Long surveyorId);
}
