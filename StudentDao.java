package manytoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone_uni.dto.College;
import manytoone_uni.dto.Student;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shivani");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveStudent(Student student) {
		entityTransaction.begin();

		entityManager.persist(student.getCollege()); // wrong
		// entityManager.merge(student.getCollege()); 1 way
		entityManager.persist(student);
		entityTransaction.commit();
		System.out.println("Student save");
	}

	public void saveStudentToExistingCollege(List<Student> list, int collegeId) {
		College college = entityManager.find(College.class, collegeId);
		if (college != null) {
			entityTransaction.begin();
			for (Student student : list) {
				student.setCollege(college);
				entityManager.persist(student);
			}
			entityTransaction.commit();
			System.out.println("Student Saved");
		} else {
			System.out.println("College not found");
		}
	}
	
	public void findStudent(int id) {
		Student student=entityManager.find(Student.class, id);
		if(student!=null) {
			System.out.println(student);
		}
		else {
			System.out.println("Student not found");
		}
	}
	
	public void findAllStudent() {
		Query query = entityManager.createQuery("select s from Student s");
		System.out.println(query.getResultList());
	}

}
