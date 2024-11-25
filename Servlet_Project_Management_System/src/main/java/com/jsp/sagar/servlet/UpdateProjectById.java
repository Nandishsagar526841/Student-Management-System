package com.jsp.sagar.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update-project")
public class UpdateProjectById extends HttpServlet{

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
			PreparedStatement stm=con.prepareStatement("update project set projectName=?,projectBudget=?,projectDomain=?,projectCountry=? where ProjectId=?");
		
			stm.setString(1, pName);
			stm.setInt(2, budget);
			stm.setString(3, domain);
			stm.setString(4, country);
			stm.setInt(5, pId);
					
		    stm.execute();
					
					resp.sendRedirect("display-project");
							
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
