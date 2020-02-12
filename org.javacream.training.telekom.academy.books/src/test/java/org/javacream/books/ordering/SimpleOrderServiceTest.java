package org.javacream.books.ordering;

import org.javacream.books.ordering.impl.JpaOrderService;
import org.junit.Test;

public class SimpleOrderServiceTest {
@Test(expected = NullPointerException.class) public void testOrderService() {
	JpaOrderService simpleOrderService = new JpaOrderService();
	simpleOrderService.order("egal", 42);
}
}
