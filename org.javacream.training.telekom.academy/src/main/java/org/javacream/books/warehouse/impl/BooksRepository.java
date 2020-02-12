package org.javacream.books.warehouse.impl;

import java.util.List;

import org.javacream.books.warehouse.api.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<Book, String> {
	List<Book> findByTitle(String title);

}
