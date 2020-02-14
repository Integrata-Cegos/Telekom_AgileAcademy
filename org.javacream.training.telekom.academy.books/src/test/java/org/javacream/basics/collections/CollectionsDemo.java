package org.javacream.basics.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.Test;

public class CollectionsDemo {

	@Test public void testCollections() throws Exception{
		List<String> names = new ArrayList<>();
		names.add("Hugo");
		names.add("Emil");
		names.add("Zvonimir");
		names.add("Fritz");
		names.add("Hans");
		names.add("Horst");
		doData(names.stream());
		//doData(Files.readAllLines(null).stream());
	}
	
	private void doData(Stream<String> stream) {
		Demo d = new Demo("H");
		Demo d2 = new Demo("Z");
		
		Consumer<Object> printer = (o) -> System.out.println(o);
		Consumer<Object> printer2 = System.out::println;
		Consumer<Object> printer3 = d::doThat;
		
		//stream.filter((s) -> d.doFilter(s)).map((s) -> s.length()).forEach(printer);
		stream.filter(d2::doFilter).map(d::transform).forEach(d::doThat);
		
		
		//Scratch: filter(c){if c(param) }
	}
	
	class Demo{
		
		private String filterString;

		public Demo(String s) {
			filterString = s;
		}
		public void doThis() {
			
		}
		
		public void doThat(Object o) {
			System.out.println(o.hashCode());
		}
		
		public boolean doFilter(String s) {
			return s.startsWith(filterString);
		}

		public int transform(String s) {
			return s.length();
		}
	}
}
