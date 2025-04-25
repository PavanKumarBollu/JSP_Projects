package com.pavan.dao;

import com.pavan.dto.Student;

public interface IStudentDao {
	public Student searchStudent(Integer sId);
	public String addStudent(Student student);
	public String updateStudent(Student student);
	public String deleteStudent(Integer sId);
}
