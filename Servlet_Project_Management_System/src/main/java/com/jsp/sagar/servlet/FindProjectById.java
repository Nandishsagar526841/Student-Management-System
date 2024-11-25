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

@WebServlet("/find-by-id")
public class FindProjectById extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
		int projectId=Integer.parseInt(req.getParameter("projectId"));
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_project_management_system","root","root");
			PreparedStatement stm=con.prepareStatement("select * from project where projectId=?");
					stm.setInt(1, projectId);
					
					ResultSet rs=stm.executeQuery();
					
					
					req.setAttribute("resultSet", rs);
					RequestDispatcher rd=req.getRequestDispatcher("FindProject.jsp");
					rd.forward(req, resp);
							
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
