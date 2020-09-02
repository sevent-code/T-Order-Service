/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.orderservice.controller;


import com.demo.orderservice.exception.MyResourceNotFoundException;
import com.demo.orderservice.model.Order;
import com.demo.orderservice.model.Surveyor;
import com.demo.orderservice.service.OrderServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Steven Raylianto K.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping("get_orders/{surveyorId}")
    public List<Order> getOrders(@PathVariable("surveyorId") Long surveyorId) throws Exception {
        return orderServiceImpl.getOrders(surveyorId);

    }
}
