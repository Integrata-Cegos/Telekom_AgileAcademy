package org.javacream.books.ordering.impl;

import org.javacream.books.ordering.api.Order;
import org.javacream.books.ordering.api.Order.OrderStatus;
import org.javacream.books.ordering.api.OrderService;
import org.javacream.books.store.api.ReadingStoreService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaOrderService implements OrderService {

	@Autowired private OrderRepository orderRepository;
	@Autowired
	private BooksService booksService;
	@Autowired
	private ReadingStoreService storeService;
	@Autowired private SequenceGenerator sequenceGenerator;
	@Override

	public Order order(String isbn, int number) {
		OrderStatus orderStatus;
		double totalPrice = 0;
		if (isbn == null) {
			throw new IllegalArgumentException("isbn was null");
		}
		if (number <= 0) {
			throw new IllegalArgumentException("number must be poitive, was " + number);
		}

		try {
			Book book = booksService.findBookByIsbn(isbn);
			totalPrice = book.getPrice() * number;
			int stock = storeService.getStock("BOOKS", isbn);
			if (stock < number) {
				orderStatus = OrderStatus.PENDING;
			} else {
				orderStatus = OrderStatus.OK;
			}
		}

		catch (BookException bookException) {
			orderStatus = OrderStatus.UNAVAILABLE;
		}
		
		Order order =  new Order(sequenceGenerator.nextKey(), isbn, totalPrice, orderStatus);
		orderRepository.save(order);
		return order;
	}
	@Override
	public Order findById(Long id) {
		return orderRepository.findById(id).get();
	}

}
