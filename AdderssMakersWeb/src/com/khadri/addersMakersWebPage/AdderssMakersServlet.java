package com.khadri.addersMakersWebPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.cj.jdbc;
import com.mysql.cj.jdbc.PreparedStatementWrapper;

public class AdderssMakersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("bottom.html");

			Class.forName(com.mysql.cj.jdbc.Driver.class.getName());
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Web", "root",
					"Wellcome@123");
			String n = request.getParameter("ProName");
			String n1 = request.getParameter("ProName");
			String n2 = request.getParameter("ProName");
			String n3 = request.getParameter("ProName");
			PreparedStatement prepare = connection.prepareStatement(
					"Select * from Propertyetilis where PropertyName=? and PropertyType=?,PropertyCast=?,PropertyAdderss=?,ContactNum=?");
			prepare.setString(1, n);
			prepare.setString(2, n1);
			prepare.setString(3, n2);
			prepare.setString(4, n3);
			ResultSet rs = prepare.executeQuery();
			if (rs.next()) {
				String url = "/Add.jsp";
				ServletContext context = getServletContext();
				 

				RequestDispatcher rd = request.getRequestDispatcher(" Add.jsp");
		rd.forward(request, response);	
			} 
			else
			{
             out.println("<font color=pink size=19>rigister Failed!!<br>");
             out.println("<a href =Add.jsp>Try Agien!!</a>");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
