package org.javacream.demo.transactional;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.util.audit.api.AuditService;
import org.javacream.util.audit.impl.DatabaseAuditImpl;
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
public class TransactionalDemo {

	@Autowired
	private AuditService auditService;
	@Autowired
	private IsbnGenerator isbnGenerator;

	@Test
	public void contextLoads() {
	}

	// @Test
	public void auditIsWritten() {
		DatabaseAuditImpl.shouldRollback = false;
		auditService.audit("Hello");
		Assert.assertTrue(auditService.logAll().get(0).equals("Hello"));
	}

	// @Test
	public void auditIsRolledBack() {
		DatabaseAuditImpl.shouldRollback = true;
		try {
			auditService.audit("World");
		} catch (RuntimeException e) {
			// OK
		}
		System.out.println(auditService.logAll());
	}

	// @Test
	public void testIsbnGeneratorWithAudit() {
		DatabaseAuditImpl.shouldRollback = false;
		System.out.println(isbnGenerator.next());
		System.out.println(isbnGenerator.next());
		System.out.println(auditService.logAll());
	}

	@Test
	public void testIsbnGeneratorWithAuditRolledBack() {
		DatabaseAuditImpl.shouldRollback = true;
		try {
			System.out.println(isbnGenerator.next());
		} catch (RuntimeException e) {
			// OK
		}
		try {
			System.out.println(isbnGenerator.next());
		} catch (RuntimeException e) {
			// OK
		}
		System.out.println(auditService.logAll());
		DatabaseAuditImpl.shouldRollback = false;
		System.out.println(isbnGenerator.next());
	}

}
