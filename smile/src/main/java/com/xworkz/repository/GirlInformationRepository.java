package com.xworkz.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.entity.GirlInformationEntity;

public class GirlInformationRepository {
	public GirlInformationRepository() {
		System.out.println("GirlInformationRepository ");
	}

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager manager = factory.createEntityManager();

	public boolean onSave(GirlInformationEntity gentity) {
		System.out.println("running save method in repo");
		EntityTransaction entityTransaction = manager.getTransaction();
		entityTransaction.begin();
		manager.persist(gentity);
		entityTransaction.commit();
		manager.close();
		return true;
	}

	public GirlInformationEntity findbyId(int id) {
		GirlInformationEntity greference = manager.find(GirlInformationEntity.class, id);
		System.out.println("find by Id method:" + greference);
		return greference;
	}

	public List<GirlInformationEntity> findAll() {
		Query query = manager.createNamedQuery("findAll");
		System.out.println("this is Query:" + query);
		return query.getResultList();
	}

	public List<GirlInformationEntity> findByName(String name) {
		EntityManager manager = factory.createEntityManager();
		System.out.println("name is:" + name);
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("byName", name);
		return query.getResultList();
	}

	public boolean update(String name, int id) {
		EntityTransaction entityTransaction = manager.getTransaction();
		entityTransaction.begin();

		GirlInformationEntity entity = manager.find(GirlInformationEntity.class, id);
		System.out.println("getting thr entity:" + entity);
		entity.setName(name);

		System.out.println("entity after setting the name:" + entity);
		manager.merge(entity);
		entityTransaction.commit();
		return true;
	}

	public boolean delete(int id) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		GirlInformationEntity entity = manager.find(GirlInformationEntity.class, id);
		manager.remove(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	public List<GirlInformationEntity> findAllLocation(String location) {
		System.out.println("Native:" + location);
		Query namedQuery = manager.createNamedQuery("findByLocation");
		namedQuery.setParameter("byLocation", location);
		return namedQuery.getResultList();

	}

//	public boolean deleteByName(String name) {
//		if(name.equals(findByName("Alia")))
//		return true;
//	}
	List<GirlInformationEntity> list = new LinkedList();

	public boolean deleteByName(String name) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("byName", name);

		list = query.getResultList();
		boolean delete = false;
		for (GirlInformationEntity girlInformationEntity : list) {
			manager.remove(girlInformationEntity);
			delete = true;
		}

		transaction.commit();
		manager.close();
		return delete;
	}

}
