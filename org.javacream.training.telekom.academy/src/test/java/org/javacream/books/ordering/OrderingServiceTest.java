package org.javacream.books.ordering;

import org.javacream.books.ordering.api.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OrderingServiceTest {

	@Autowired OrderService orderService;
	
	@Test public void testOrderServiceAvailable() {
		Assert.assertNotNull(orderService);
	}
	
}
