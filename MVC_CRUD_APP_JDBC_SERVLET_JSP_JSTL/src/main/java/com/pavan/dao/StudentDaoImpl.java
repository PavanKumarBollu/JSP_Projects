package com.pavan.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pavan.dto.Student;
import com.pavan.util.JDBCUitls;

public class StudentDaoImpl implements IStudentDao {
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet res = null;
	private Student student = null;
	@Override
	public Student searchStudent(Integer sId) {
		try {
			connection = JDBCUitls.getConnection();
			if(connection != null) {
				 pst = connection.prepareStatement("select sid, sname, sage,saddress from student where sid = ?");
				 
			}
			if(pst!= null)
			{
				pst.setInt(1, sId);
				res = pst.executeQuery();
				
			}
			if(res!= null)
			{
				if(res.next())
				{
					student = new Student();
					student.setsId(res.getInt("sId"));
					student.setsName(res.getString("sName"));
					student.setsAge(res.getInt("sAge"));
					student.setsAddress(res.getString("sAddress"));
					
					return student;
				}
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally{
			if(res!=null)
			{
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null)
			{
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return student;
	}

	@Override
	public String addStudent(Student student) {
		String query = "insert into student(sName, sAge, sAddress)values(?,?,?)";
		
		try {
			connection = JDBCUitls.getConnection();
			if(connection!= null) {
				pst = connection.prepareStatement(query);
			}
			if(pst!=null)
			{
				pst.setString(1, student.getsName());
				pst.setInt(2, student.getsAge());
				pst.setString(3, student.getsAddress());
				int rowsAffected = pst.executeUpdate();
				if(rowsAffected!= 0)
					return "success";
			}
			
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String updateStudent(Student student) {
		String query = "update student set sName=?, sAge=?, sAddress=? where sId = ?";
		try {
			connection = JDBCUitls.getConnection();
			
			if(connection != null)
			{
				pst = connection.prepareStatement(query);
			}
			if(pst != null)
			{
				pst.setString(1, student.getsName());
				pst.setInt(2, student.getsAge());
				pst.setString(3, student.getsAddress());
				pst.setInt(4, student.getsId());
				int rowsAffected = pst.executeUpdate();
				if(rowsAffected != 0)
					return "success";
				
			}
					
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return "failure";
	}

	@Override
	public String deleteStudent(Integer sId) {
		try {
			String query = "delete from student where sId =?";
			connection = JDBCUitls.getConnection();
			
			if(connection != null)
			{
				pst = connection.prepareStatement(query);
			}
			if(pst!=null)
			{
				pst.setInt(1, sId);
				int rowsAffected = pst.executeUpdate();
				if(rowsAffected != 0)
				{
					return "success";
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return "failure";
	}

}
