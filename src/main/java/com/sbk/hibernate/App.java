package com.sbk.hibernate;

import java.util.List;

import com.sbk.hibernate.dao.StudentDao;
import com.sbk.hibernate.model.Student;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDao studentDao = new StudentDao();
		
		Student student = new Student("Chirag", "Sardana", "Chiragsardana12@gmail.com");
		studentDao.saveStudent(student);
		Student student1 = new Student("Nitin", "Arora", "AroraNitin@gmail.com");
		
		//Get Students by id
		//It return nulls
		System.out.println("Student Object is "+studentDao.getStudentById(0));
		System.out.println("Student Object is "+studentDao.getStudentById(1));
		
		studentDao.saveStudent(student1);
		//Updating 2nd Student
		student1.setEmail("NitinArora@gmail.com");
		studentDao.updateStudent(student1);
		System.out.println("Student1 Object is "+studentDao.getStudentById(2));
		//Delete 2nd Student
		System.out.println("Now Deleting the Student Object");
		studentDao.deleteStudentById(2);
		System.out.println("Get All the List of Students");
		List<Student> students = studentDao.getAllStudents();
		for(int i = 0; i < students.size();i++) {
			System.out.println(students.get(i));
		}
		
	}

}
