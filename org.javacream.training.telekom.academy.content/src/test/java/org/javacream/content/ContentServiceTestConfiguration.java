package org.javacream.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.javacream.content.api.Content;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContentServiceTestConfiguration {

	@Bean @Qualifier("contentStore") Map<String, Content> contentStore(){
		HashMap<String, Content> testData = new HashMap<>();
		List<String> tags1 = new ArrayList<String>();
		tags1.add("IT");
		tags1.add("Java");
		tags1.add("Spring");
		Content content = new Content("SpringinAction", tags1, "A very good book".getBytes());
		testData.put(content.getId(), content);
		return testData;
	}
}
