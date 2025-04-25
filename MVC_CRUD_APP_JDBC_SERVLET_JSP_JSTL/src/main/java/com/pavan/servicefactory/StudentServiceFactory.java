package com.pavan.servicefactory;

import com.pavan.service.IStudentService;
import com.pavan.service.StudentServiceImple;

public class StudentServiceFactory {
	private StudentServiceFactory()
	{
		// to Prevent the object Creation
	}
	private static IStudentService studentService = null;
	public static IStudentService getStudentService()
	{
		if(studentService == null)
		{
			studentService = new StudentServiceImple();
		}
		return studentService;
	}
}
