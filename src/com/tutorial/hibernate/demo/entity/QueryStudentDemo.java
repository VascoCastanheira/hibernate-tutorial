package com.tutorial.hibernate.demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class QueryStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

			
		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").getResultList();
			
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.lastName = 'Castanheira'").getResultList();
			
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.lastName = 'Castanheira' OR s.firstName = 'Bob'").getResultList();
			
			displayStudents(students);			
			
			students = session.createQuery("from Student s where s.email like '%castanheira%'").getResultList();
			
			displayStudents(students);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student tmp : students) {
			System.out.println(tmp);
		}
	}

}
