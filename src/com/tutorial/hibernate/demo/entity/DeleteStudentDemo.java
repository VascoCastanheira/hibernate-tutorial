package com.tutorial.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

			
		
		try {
			
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
	
			session.createQuery("delete from Student where id='2'").executeUpdate();
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
