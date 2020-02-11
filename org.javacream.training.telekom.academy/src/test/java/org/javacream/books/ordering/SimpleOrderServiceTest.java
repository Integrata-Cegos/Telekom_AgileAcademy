package org.javacream.books.ordering;

import org.javacream.books.ordering.impl.SimpleOrderService;
import org.junit.Test;

public class SimpleOrderServiceTest {
@Test(expected = NullPointerException.class) public void testOrderService() {
	SimpleOrderService simpleOrderService = new SimpleOrderService();
	simpleOrderService.order("egal", 42);
}
}
