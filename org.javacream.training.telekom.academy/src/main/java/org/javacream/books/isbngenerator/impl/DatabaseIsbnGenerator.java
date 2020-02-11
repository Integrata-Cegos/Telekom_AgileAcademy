package org.javacream.books.isbngenerator.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.util.audit.api.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseIsbnGenerator implements IsbnGenerator{
	@Autowired private AuditService auditService;
	@PersistenceContext private EntityManager entityManager;
	public DatabaseIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix, @Value("${isbngenerator.suffix}")String suffix) {
		if (prefix == null || suffix ==  null) {
			throw new IllegalArgumentException ("prefix and suffix must not be null");
		}
		this.prefix = prefix;
		this.suffix = suffix;
	}
	private String prefix;
	private String suffix;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String next() {
		Integer key = (Integer) entityManager.createNativeQuery("select col_key from keys").getSingleResult();
		key++;
		Query query = entityManager.createNativeQuery("update keys set col_key= :key");
		query.setParameter("key", key);
		query.executeUpdate();
		String isbn = prefix + key + suffix;
//		try {
		auditService.audit("created isbn: " + isbn);
//		}
//		catch(RuntimeException e) {
//			System.out.println("CATCHED EXCEPTION!");
//		}
		return isbn;
	}
}
