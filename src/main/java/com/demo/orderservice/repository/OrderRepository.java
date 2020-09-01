/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.orderservice.repository;

import com.demo.orderservice.model.Order;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Steven Raylianto K.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
    
}
