package manytoone_uni.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.internal.build.AllowSysOut;

import manytoone_uni.dao.CollegeDao;
import manytoone_uni.dao.StudentDao;
import manytoone_uni.dto.College;
import manytoone_uni.dto.Student;

public class MainController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDao studentDao=new StudentDao();
		CollegeDao collegeDao=new CollegeDao();
		List<Student>list=new ArrayList<Student>();
		
		System.out.println("Enter Your Choice");
		System.out.println("1.create database\n2.Save the college and student both\n3.Save the Student in existing College"
				+ "\n4.Save College only\n5.Find Student\n6.find college"
				+ "\n7.find all colleges\n8.find all Students\n9.Update college");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:{
			College college=new College();
			
			college.setId(101);
			college.setName("Garware Clooege");
			college.setFees(20000.0);
			
			Student student1=new Student();
			student1.setId(1);
			student1.setName("Radha");
			student1.setPhone(987654321);
			student1.setAddress("pune");
			student1.setCollege(college);
			
			Student student2=new Student();
			student2.setId(2);
			student2.setName("Krishna");
			student2.setPhone(879654321);
			student2.setAddress("pune");
			student2.setCollege(college);
			
			
			Student student3=new Student();
			student3.setId(3);
			student3.setName("Baldau");
			student3.setPhone(507654321);
			student3.setAddress("pune");
			student3.setCollege(college);
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shivani");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			entityTransaction.begin();
			entityManager.persist(college);
			entityManager.persist(student1);
			entityManager.persist(student2);
			entityManager.persist(student3);
			entityTransaction.commit();
			break;
		}
		case 2:{
			College college=new College();
			System.out.println("enter the college id");
			college.setId(scanner.nextInt());
			
			System.out.println("enter the clg name");
			college.setName(scanner.next());
			
			System.out.println("enter the fees");
			college.setFees(scanner.nextDouble());
			
			System.out.println("How many Student you want to enter");
			int ct=scanner.nextInt();
			
			for (int i = 0; i < ct; i++) {
				Student student=new Student();
				System.out.println("Enter the Student id");
				student.setId(scanner.nextInt());
				
				System.out.println("Enter the Student name");
				student.setName(scanner.next());
				
				System.out.println("Enter the Student phone");
				student.setPhone(scanner.nextLong());
				
				System.out.println("Enter the Student address");
				student.setAddress(scanner.next());
				
				student.setCollege(college);
				studentDao.saveStudent(student);
			}
			
			
			
			break;
		}
		case 3:{
			System.out.println("How many Student you want to enter");
			int ct=scanner.nextInt();
			
			for (int i = 0; i < ct; i++) {
				Student student=new Student();
				System.out.println("Enter the Student id");
				student.setId(scanner.nextInt());
				
				System.out.println("Enter the Student name");
				student.setName(scanner.next());
				
				System.out.println("Enter the Student phone");
				student.setPhone(scanner.nextLong());
				
				System.out.println("Enter the Student address");
				student.setAddress(scanner.next());
				
				list.add(student);
			}
			System.out.println("Enter the college id to add student");
			int collegeId=scanner.nextInt();
			
			studentDao.saveStudentToExistingCollege(list, collegeId);	
			break;
		}
		case 4:{
			College college=new College();
			System.out.println("enter the college id");
			college.setId(scanner.nextInt());
			
			System.out.println("enter the clg name");
			college.setName(scanner.next());
			
			System.out.println("enter the fees");
			college.setFees(scanner.nextDouble());
			
			collegeDao.saveCollege(college);
			break;
		}
		case 5:{
			System.out.println("Enter the Student id to find");
			int id=scanner.nextInt();
			studentDao.findStudent(id);
			break;
		}
		case 6:{
			System.out.println("Enter the College id to find");
			int id=scanner.nextInt();
			collegeDao.findCollege(id);
			break;
		}
		case 7:{
			collegeDao.findAllColleges();
			break;
		}
		case 8:{
			studentDao.findAllStudent();
			break;
		}
		case 9:{
			
			break;
		}
		default:
			break;
		}
	}

}
