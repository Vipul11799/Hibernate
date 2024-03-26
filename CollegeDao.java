package manytoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone_uni.dto.College;

public class CollegeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shivani");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveCollege(College college) {
		entityTransaction.begin();
		entityManager.persist(college);
		entityTransaction.commit();
		System.out.println("College Save");
	}
	public void findCollege(int id) {
		College college= entityManager.find(College.class, id);
		
		if(college!=null) {
			System.out.println(college);
		}else {
			System.out.println("College not found");
		}
	}
	public void findAllColleges() {
		Query query = entityManager.createQuery("select c from College c");
		System.out.println(query.getResultList());
	}
	public void updateCollege(College college,int id) {
		
	}

}
