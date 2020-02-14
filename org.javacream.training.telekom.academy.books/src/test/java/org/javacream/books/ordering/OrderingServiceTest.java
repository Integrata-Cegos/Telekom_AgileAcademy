package org.javacream.books.ordering;

import org.javacream.books.ordering.api.Order;
import org.javacream.books.ordering.api.Order.OrderStatus;
import org.javacream.books.store.api.ReadingStoreService;
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
	private static final String ISBN1 = "ISBN1";
	private static final String INVALID_ISBN = "#!%&";
	private static final int AVAILABLE_IN_STOCK = 10;
	private static final int UNAVAILABLE_IN_STOCK = 20;

	@Autowired
	OrderService orderService;
	@Autowired
	ReadingStoreService storeService;

	@Test
	public void testOrderServiceAvailable() {
		Assert.assertNotNull(orderService);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullIsbnMustThrowIllegalArgumentException() {
		orderService.order(null, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nonPositiveNumberMustThrowIllegalArgumentException() {
		orderService.order(ISBN1, -1);
	}

	@Test
	public void orderingAvailableStockIsbn1CreatesOkOrder() {
		Order order = orderService.order(ISBN1, AVAILABLE_IN_STOCK);
		Assert.assertTrue(order.getStatus() == OrderStatus.OK);
	}

	@Test
	public void orderingAvailableStockIsbn1CreatesOrderWithTotalPrice() {
		Order order = orderService.order(ISBN1, AVAILABLE_IN_STOCK);
		Assert.assertEquals(99.9, order.getTotalPrice(), 1e-12);
	}

	@Test
	public void orderingUnavailableStockIsbn1CreatesPendingOrder() {
		Order order = orderService.order(ISBN1, UNAVAILABLE_IN_STOCK);
		Assert.assertTrue(order.getStatus() == OrderStatus.PENDING);
	}

	@Test
	public void orderingUnknownIsbnAndAvailableStockCreatesUnavailableOrder() {
		Order order = orderService.order(INVALID_ISBN, AVAILABLE_IN_STOCK);
		Assert.assertTrue(order.getStatus() == OrderStatus.UNAVAILABLE);
	}

	@Test
	public void orderingUnknownIsbnAndUnavailableStockCreatesUnavailableOrder() {
		Order order = orderService.order(INVALID_ISBN, UNAVAILABLE_IN_STOCK);
		Assert.assertTrue(order.getStatus() == OrderStatus.UNAVAILABLE);
	}

	@Test
	public void ordersHaveUniqueId() {
		Order order1 = orderService.order(ISBN1, AVAILABLE_IN_STOCK);
		Order order2 = orderService.order(ISBN1, AVAILABLE_IN_STOCK);
		Assert.assertTrue(order1.getOrderId() != order2.getOrderId());
	}

}
