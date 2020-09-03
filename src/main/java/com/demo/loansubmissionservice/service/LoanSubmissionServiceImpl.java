/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.loansubmissionservice.service;

import com.demo.loansubmissionservice.exception.MyResourceException;
import com.demo.loansubmissionservice.model.LoanSubmission;
import com.demo.loansubmissionservice.model.Surveyor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.demo.loansubmissionservice.repository.LoanSubmissionRepository;

/**
 *
 * @author Steven Raylianto K.
 */
@Service
public class LoanSubmissionServiceImpl implements LoanSubmissionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoanSubmissionRepository orderRepository;

    @Override
    public LoanSubmission createOrder(LoanSubmission order) {
        return orderRepository.save(order);
    }

    @Override
    public LoanSubmission updateOrder(Long id, LoanSubmission orderRequest) {
        return orderRepository.findById(id).map(order -> {
            order.setDescription(orderRequest.getDescription());
            order.setLatitude(orderRequest.getLatitude());
            order.setLongitude(orderRequest.getLongitude());
            return orderRepository.save(order);
        }).orElseThrow(() -> new MyResourceException("Error when update order with id " + id));

    }

    @Override
    public ResponseEntity<?> deleteOrder(Long id) {
        return orderRepository.findById(id).map(order -> {
            orderRepository.delete(order);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new MyResourceException("Order id " + id + " not found"));
    }

    @Override
    public List<LoanSubmission> getOrders(Long surveyorId) {
        Surveyor surveyor = restTemplate.getForObject("http://surveyor-service/surveyor/find-by-id?value=" + surveyorId, Surveyor.class);
        System.out.println(surveyor.toString());
        return null;
    }

}
