package com.capgemini.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.order.entity.Order;


public interface OrderRepository extends MongoRepository<Order, Integer>
{

}
