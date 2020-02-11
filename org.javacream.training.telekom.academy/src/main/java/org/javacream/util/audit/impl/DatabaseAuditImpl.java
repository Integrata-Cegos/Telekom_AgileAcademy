package org.javacream.util.audit.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.util.audit.api.AuditService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DatabaseAuditImpl implements AuditService{

	@PersistenceContext private EntityManager entityManager;
	@Override
	public void audit(String message) {
		Query query = entityManager.createNativeQuery("insert into AUDIT values(:message)");
		query.setParameter("message", message);
		query.executeUpdate();
	}

	@Override
	public List<String> logAll() {
		return entityManager.createNativeQuery("select message from AUDIT").getResultList();
	}

}
