package com.pavan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pavan.dto.Student;
import com.pavan.service.IStudentService;
import com.pavan.servicefactory.StudentServiceFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		System.out.println("Request URI 	: " + request.getRequestURI());
		System.out.println("Request Path 	: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("addform")) {
			String sName = request.getParameter("sname");
			Integer sAge = Integer.parseInt(request.getParameter("sage"));
			String sAddress = request.getParameter("saddress");

			Student student = new Student();
			student.setsAddress(sAddress);
			student.setsName(sName);
			student.setsAge(sAge);

			String result = studentService.addStudent(student);
			RequestDispatcher rd = null;
			if ("success".equals(result)) {
				request.setAttribute("status", result);
				rd = request.getRequestDispatcher("insertResult.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("status", result);
				rd = request.getRequestDispatcher("insertResult.jsp");
				rd.forward(request, response);
			}

		}

	}

}
