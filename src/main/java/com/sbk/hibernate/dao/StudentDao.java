package com.sbk.hibernate.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sbk.hibernate.model.Student;
import com.sbk.hibernate.util.HibernateUtil;

public class StudentDao {
	//saveStudent
	//getAllStudents
	//getStudentById
	//UpdateStudent
	//DeleteStudent
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Start the transaction
			transaction = session.beginTransaction();
			
			//Save Student object
			session.save(student);
			
			//Commit the transaction
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			
		}
	}
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Start the transaction
			transaction = session.beginTransaction();
			
			//Save or update Student object
			session.saveOrUpdate(student);
			
			//Commit the transaction
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			
		}
	}
	public Student getStudentById(long id) {
		Transaction transaction = null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Start the transaction
			transaction = session.beginTransaction();
			
			//Get Student object
			student = session.get(Student.class, id);
			//We can also use load method to load particular student object from db
//			student = session.load(Student.class, id);
			
			//Commit the transaction
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			
		}
		return student;
	}
	public List<Student> getAllStudents() {
		Transaction transaction = null;
		List<Student> students = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Start the transaction
			transaction = session.beginTransaction();
			
			//Get Students object
			students = session.createQuery("from Student").list();
			
			//Commit the transaction
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			
		}
		return students;
	}
	public void deleteStudentById(long id) {
		Transaction transaction = null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Start the transaction
			transaction = session.beginTransaction();
			
			//Get Student object
			student = session.get(Student.class, id);
			//Now Delete the Student Object
			session.delete(student);
			
			//Commit the transaction
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			
		}
	}
	
}
