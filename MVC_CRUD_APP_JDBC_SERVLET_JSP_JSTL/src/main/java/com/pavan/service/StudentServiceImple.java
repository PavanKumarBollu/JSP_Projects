package com.pavan.service;

import com.pavan.daofactory.StudentDaoFactory;
import com.pavan.dto.Student;

public class StudentServiceImple implements IStudentService {

	@Override
	public String addStudent(Student student) {
		return StudentDaoFactory.getStudentDao().addStudent(student);
	}

	@Override
	public Student searchStudent(Integer sId) {
		
		return StudentDaoFactory.getStudentDao().searchStudent(sId);
		
	}

	@Override
	public String updateStudent(Student student) {
		return StudentDaoFactory.getStudentDao().updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sId) {
		return StudentDaoFactory.getStudentDao().deleteStudent(sId);
	}

}
