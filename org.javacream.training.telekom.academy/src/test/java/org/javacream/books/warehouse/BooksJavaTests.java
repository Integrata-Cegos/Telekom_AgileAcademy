package org.javacream.books.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.javacream.books.warehouse.api.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BooksJavaTests {

	@Autowired
	@Qualifier("generatorsMap")
	private Map<Set<String>, Function<Map<String, Object>, Book>> generators;

	@Test public void testCreateSchoolBook() {
		HashMap<String, Object> optionsForSchoolBook = new HashMap<>();
		optionsForSchoolBook.put("subject", "physics");
		optionsForSchoolBook.put("year", 10);
		
		
		Function<Map<String, Object>, Book> generator = generators.get(optionsForSchoolBook.keySet());
		Book book = generator.apply(optionsForSchoolBook);
		System.out.println(book.getClass().getName());
		
		HashMap<String, Object> optionsForSpecialistBook = new HashMap<>();
		optionsForSpecialistBook.put("topic", "Java");
		Function<Map<String, Object>, Book> generator2 = generators.get(optionsForSpecialistBook.keySet());
		Book book2 = generator2.apply(optionsForSpecialistBook);
		System.out.println(book2.getClass().getName());
		
	}
}
