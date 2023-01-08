package com.tutorial.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

			
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating student...");
			Student student = new Student("Vasco", "Castanheira", "vasco.murta.castanheira@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving student...");
			session.save(student);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
