package com.jsp.sagar.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-project")
public class AddProjectServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pId=Integer.parseInt(req.getParameter("projectId"));
		String pName=req.getParameter("projectName");
		int budget=Integer.parseInt(req.getParameter("projectBudget"));
		String domain=req.getParameter("projectDomain");
		String country=req.getParameter("projectCountry");
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_project_management_system","root","root");
			PreparedStatement stmt=con.prepareStatement("insert into project values(?,?,?,?,?)");
			stmt.setInt(1, pId);
			stmt.setString(2, pName);
			stmt.setInt(3, budget);
			stmt.setString(4, domain);
			stmt.setString(5, country);
			boolean rs=stmt.execute();
			resp.sendRedirect("index.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
