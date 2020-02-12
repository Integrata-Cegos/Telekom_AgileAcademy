package org.javacream.books.ordering;

import org.javacream.books.ordering.api.Order;
import org.javacream.books.ordering.api.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OrderingServiceScenarioTest {
	@Autowired
	OrderService orderService;
	
	
	@Test public void testScenario() {
		Order order = orderService.order("ISBN1", 20);
		Order order2 = orderService.order("ISBN1", 3);
		Order order3 = orderService.order("HUGO", 3);
		Long id = order.getOrderId();
		Long id2 = order2.getOrderId();
		Long id3 = order3.getOrderId();
		System.out.println(orderService.findById(id));
		System.out.println(orderService.findById(id2));
		System.out.println(orderService.findById(id3));
	
	}
}
