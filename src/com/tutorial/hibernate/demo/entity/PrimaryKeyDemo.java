package com.tutorial.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

			
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating student...");
			
			Student student = new Student("Vasco", "Castanheira", "vasco.murta.castanheira@gmail.com");
			Student student1 = new Student("Bob", "Construtor", "bob.construtor@gmail.com");
			Student student2 = new Student("Anita", "Fugosa", "anita.fugosa@gmail.com");
			
			
			session.beginTransaction();
			
			System.out.println("Saving student...");
			session.save(student);
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

		
}
