package org.javacream.books.ordering.impl;

import org.javacream.books.ordering.api.Order;
import org.javacream.books.ordering.api.OrderService;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleOrderService implements OrderService {

	@Autowired private BooksService booksService;
	@Autowired private StoreService storeService;
	@Override
	public Order order(String isbn, int number) {
		throw new UnsupportedOperationException("not yet implemented");
	}

}
