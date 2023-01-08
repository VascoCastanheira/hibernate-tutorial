package com.tutorial.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

			
		
		try {
			
			Session session = factory.getCurrentSession();
			System.out.println("Creating student...");
			Student student = new Student("Rui", "Barbosa", "rui.barbosa@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving student...");
			session.save(student);
			
			session.getTransaction().commit();
			
			Session newSession = factory.getCurrentSession();
			
			newSession.beginTransaction();
			
			System.out.println("Primary key of created student: " + student.getId());
			
			Student dbStudent = newSession.get(Student.class, student.getId());
			
			newSession.getTransaction().commit();
			
			System.out.println(dbStudent.toString());
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
