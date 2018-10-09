package com.capgemini.order.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.order.entity.Order;
import com.capgemini.order.service.OrderService;


@RestController
public class OrderController {
	
	static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@PostMapping("/v1/order")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		logger.info("Add order  /v1/order");
		return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.OK);
	}

}
