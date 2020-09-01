/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.orderservice.service;

import com.demo.orderservice.model.Order;
import java.util.List;

/**
 *
 * @author Steven Raylianto K.
 */
public interface OrderService {
    Order createOrder(Order order);
    void deleteOrder(Order order);
    List<Order> getOrders(Long surveyorId) throws Exception;
}
