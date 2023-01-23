package com.tutorial.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

			
		
		try {
			
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			String studentId = "1";
			
			Student student = session.get(Student.class, studentId);
			
			System.out.println(student.toString());
			
			student.setFirstName("Vasco");
			
			session.getTransaction().commit();
			
			System.out.println(student.toString());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();	
			
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
