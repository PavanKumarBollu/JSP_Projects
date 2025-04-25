package com.pavan.daofactory;

import com.pavan.dao.IStudentDao;
import com.pavan.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private StudentDaoFactory()
	{
		// to prevent the object Creation
	}
	
	private static IStudentDao studentDao = null;
	public static IStudentDao getStudentDao ()
	{
		if(studentDao == null)
			studentDao = new StudentDaoImpl();
		
		return studentDao;
	}
	
}
