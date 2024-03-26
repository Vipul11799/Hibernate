package manytoone_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import manytoone_uni.dto.Student;

public class CacheExecution {

	public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shivani");
	EntityManager entityManager= entityManagerFactory.createEntityManager();
	entityManager.find(Student.class, 1);
	entityManager.find(Student.class, 1);
	
	EntityManager entityManager2=entityManagerFactory.createEntityManager();
	entityManager2.find(Student.class, 1);
	entityManager2.find(Student.class, 1);
	
	EntityManager entityManager3=entityManagerFactory.createEntityManager();
	entityManager3.find(Student.class, 1);
	entityManager3.find(Student.class, 1);
	}
}
