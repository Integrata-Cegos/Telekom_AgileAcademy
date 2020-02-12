package org.javacream.jpa.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatHelper {
	@PersistenceContext private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRED)
	public void doHelp() {
		Cat searched = entityManager.find(Cat.class, 1l);
		searched.setFurColor("yellow");
	}
}
