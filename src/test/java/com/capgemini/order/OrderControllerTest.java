package com.capgemini.order;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.order.controller.OrderController;
import com.capgemini.order.entity.Order;
import com.capgemini.order.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderControllerTest {
	

	private MockMvc mockMvc;

	@Mock
	OrderService orderService;

	@InjectMocks
	OrderController orderController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}

	@Test
	public void testAddOrder() throws Exception {
		Order order = new Order(221700, 12345, 12345, LocalDate.of(2015, 05, 03));
		when(orderService.addOrder(Mockito.isA(Order.class))).thenReturn(order);
		String content = "{\"orderId\": 221700, 
				 \"customerId\": 12345,\"productId\": 12345,  \"orderDate\": \"2015-05-03\"}";
		mockMvc.perform(post("/v1/order").contentType(MediaType.APPLICATION_JSON_UTF8).content(content)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(jsonPath("$.orderId").value(221700));
	}

	
	

}
