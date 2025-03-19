<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%!
Connection connection = null;
	PreparedStatement pst1 = null;
	PreparedStatement pst2 = null;

	public void jspInit() {
		System.out.println("Connection Seccuessful");
		ServletConfig config = getServletConfig();
		String url = config.getInitParameter("url");
		String uName = config.getInitParameter("uName");
		String uPassword = config.getInitParameter("uPassword");

		try {
			String insertQuery = "inset into employee(eName,eAddress,eSalary) values(?,?,?)";
			String selectQuery = "select eId, eName, eAddress, eSalary from employee";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uName, uPassword);
			
			pst1 = connection.prepareStatement("inset into employee(eName,eAddress,eSalary) values(?,?,?)");
			pst2 = connection.prepareStatement(selectQuery);

		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}%>
<%
String action = request.getParameter("s1");

if (action.equalsIgnoreCase("register")) {
	//perporm insert Operation 
	String eName = request.getParameter("ename");
	String eAddress = request.getParameter("eaddress");
	String eSalary = request.getParameter("esalary");
	pst1.setString(1, eName);
	pst1.setString(2, eAddress);
	pst1.setInt(3, Integer.parseInt(eSalary));

	int result = pst1.executeUpdate();
	if (result == 1)
		out.println("<h1 style='color: green; text-align: center;'>Employee registered</h1>");
	else
		out.println("<h1 style='color: green; text-align: center;'>Employee registration Failed</h1>");

} else {
	// perporm Select Operation
	ResultSet result = pst2.executeQuery();
	out.println("<table><tr><th>EDI</th><th>ENAME</th><th>EADDRESS</th><th>ESALARY</th></tr>");

	while (result.next()) {
		out.println("<tr><td>" + result.getInt("eId") + "</td><td>" + result.getString("eName") + "</td><td>"
		+ result.getString("eAddress") + "</td><td>" + result.getInt("eSalary") + "</td></tr>");
	}

	out.println("</table>");
}
%>
<br>
<br>

<h1 style='text-align: center;'>
	<a href='./index.html'>|HOMEPAGE|</a>
</h1>


<%!public void jspDestroy() {
		try {
			if (pst1 != null)
				pst1.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (pst2 != null)
				pst1.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (connection != null)
				pst1.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}%>



