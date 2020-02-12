package org.javacream.jpa.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaDemoService{

	@PersistenceContext private EntityManager entityManager;
	@Autowired private CatHelper catHelper;
	@Transactional
	public void doDemo() {
		Cat cat = new Cat("Thommy", 5.55,"brown");
		Long catId = cat.getCatId();
		System.out.println(catId);
		entityManager.persist(cat);
		catId = cat.getCatId();
		System.out.println(catId);
		Cat searched = entityManager.find(Cat.class, 1l);
		searched.setWeight(9.99);
//		System.out.println(cat.getWeight());
//		System.out.println(cat == searched);
//		Cat searched2 = entityManager.createQuery("select cat from Cat as cat", Cat.class).getResultList().get(0);
//		System.out.println(cat == searched2);
//		entityManager.flush();
//		catHelper.doHelp();
//		System.out.println(cat.getFurColor());
		
	}
}
