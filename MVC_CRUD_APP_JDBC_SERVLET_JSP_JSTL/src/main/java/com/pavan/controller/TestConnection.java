package com.pavan.controller;

import com.pavan.dto.Student;
import com.pavan.service.IStudentService;
import com.pavan.servicefactory.StudentServiceFactory;

public class TestConnection {
	public static void main(String[] args) {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student std = studentService.searchStudent(1);
//		System.out.println(std);
		Student student = new Student();
		student.setsName("test");
		student.setsAge(25);
		student.setsAddress("HYD");
//		String result = studentService.addStudent(student);
//		System.out.println(result);
		
		System.out.println(studentService.deleteStudent(4));
	}
}	
