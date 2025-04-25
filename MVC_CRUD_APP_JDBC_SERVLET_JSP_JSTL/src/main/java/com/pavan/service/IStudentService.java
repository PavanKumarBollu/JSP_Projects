package com.pavan.service;

import com.pavan.dto.Student;

public interface IStudentService{
	public String addStudent(Student student);
	public Student searchStudent(Integer sId);
	public String updateStudent(Student student);
	public String deleteStudent(Integer sId);
}
