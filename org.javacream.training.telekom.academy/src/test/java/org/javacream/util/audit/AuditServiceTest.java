package org.javacream.util.audit;

import java.util.Arrays;
import java.util.List;

import org.javacream.util.audit.api.AuditService;
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
public class AuditServiceTest {
	@Autowired AuditService auditService;
	@Test
	public void testAuditService() {
		String[] array = {"Hello", "World"};
		List<String> expected = Arrays.asList(array);
		auditService.audit("Hello");
		auditService.audit("World");
		List<String> result = auditService.logAll();
		Assert.assertEquals(expected, result);
	}
	
}
