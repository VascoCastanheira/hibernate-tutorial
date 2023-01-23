package com.tutorial.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateEmployeeDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

			
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating employee...");
			Employee employee = new Employee("Vasco", "Castanheira", "Google");
			
			session.beginTransaction();
			
			System.out.println("Saving employee...");
			session.save(employee);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
