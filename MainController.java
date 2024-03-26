package manytomany_bi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_bi.dto.Application;
import manytomany_bi.dto.User;

public class MainController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shivani");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		System.out.println("Enter Your Choice");
		System.out.println("1.create database\n2.featch user\n3.featch application");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1: {
			User user1 = new User();
			user1.setName("Shivani");
			user1.setAddress("pune");
			user1.setPhone(9876);

			User user2 = new User();
			user2.setName("Tejus");
			user2.setAddress("Bng");
			user2.setPhone(8876);

			User user3 = new User();
			user3.setName("Siri");
			user3.setAddress("pune");
			user3.setPhone(7876);

			Application application1 = new Application();
			application1.setName("FB");
			application1.setCompany("Meta");

			Application application2 = new Application();
			application2.setName("Insta");
			application2.setCompany("Meta");

			Application application3 = new Application();
			application3.setName("WhatsApp");
			application3.setCompany("Meta");

			Application application4 = new Application();
			application4.setName("Snapchat");
			application4.setCompany("Beta");

			entityTransaction.begin();

			List<Application> applicationsList1 = new ArrayList<Application>();
			applicationsList1.add(application1);
			applicationsList1.add(application2);
			applicationsList1.add(application4);
			user1.setApplications(applicationsList1);

			entityManager.persist(user1);
			// ----------------------------------

			List<Application> applicationsList2 = new ArrayList<Application>();
			applicationsList2.add(application1);
			applicationsList2.add(application2);
			applicationsList2.add(application3);
			applicationsList2.add(application4);

			user3.setApplications(applicationsList2);

			entityManager.persist(user3);
			// ----------------------------------

			List<Application> applicationsList3 = new ArrayList<Application>();
			applicationsList3.add(application2);
			applicationsList3.add(application3);
			user2.setApplications(applicationsList3);

			entityManager.persist(user2);
			// ----------------------------------

			List<User> usersList1 = new ArrayList<User>();

			usersList1.add(user1);
			usersList1.add(user3);
			application1.setUsers(usersList1);
			application4.setUsers(usersList1);

			entityManager.persist(application1);
			entityManager.persist(application4);
			// ----------------------------------

			List<User> usersList2 = new ArrayList<User>();

			usersList2.add(user1);
			usersList2.add(user2);
			usersList2.add(user3);
			application2.setUsers(usersList2);

			entityManager.persist(application2);
			// ----------------------------------

			List<User> usersList3 = new ArrayList<User>();
			usersList3.add(user2);
			usersList3.add(user3);
			application3.setUsers(usersList3);

			entityManager.persist(application3);
			entityTransaction.commit();
			break;
		}
		case 2:{
			System.out.println("Enter the user Id to featch");
			int uid=scanner.nextInt();
			User dbUser =entityManager.find(User.class, uid);
			if(dbUser!=null) {
				System.out.println(dbUser);
			}
			else {
				System.out.println("user with id "+uid+" is not found!");
			}
			break;
			
		}
		case 3:{
			System.out.println("Enter the Application Id to featch");
			int aid=scanner.nextInt();
			Application dbApplication=entityManager.find(Application.class, aid);
			if(dbApplication!=null) {
				System.out.println(dbApplication);
			}
			else {
				System.out.println("Application with id "+aid+" is not found!");
			}
			break;
		}
		}

	}
}
