package com.capgemini.order.service;

import java.util.List;

import com.capgemini.order.entity.Order;
import com.capgemini.order.exception.OrderIdNotFoundException;

public interface OrderService {
	
	public Order addOrder(Order order);
	
	public Order UpdateOrder(Order order);
	
	public Order findOrderById(int orderId)throws OrderIdNotFoundException;
	
	public List<Order> findCustomerId(int customerId);
	
	


}
