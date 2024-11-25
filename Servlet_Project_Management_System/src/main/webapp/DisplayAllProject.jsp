<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<%
    ResultSet rs=(ResultSet)request.getAttribute("resultSet");
%>
   <table border="2">
   <tr>
   <th>projectId</th>
   <th>projectName</th>
   <th>projectBudget</th>
   <th>projectDomain</th>
   <th>projectCountry</th>
   <th>update</th>
   <th>delete</th>
   <tr>
   <% while(rs.next()){ %>
   <tr>
   <td><%=rs.getInt("projectId") %></td>
   <td><%=rs.getString("projectName") %></td>
   <td><%=rs.getInt("projectBudget") %></td>
   <td><%=rs.getString("projectDomain") %></td>
   <td><%=rs.getString("projectCountry") %></td>
   <td><a href="find-by-id?projectId=<%=rs.getInt("projectId") %>">update</a></td>
   <td><a href="delete-by-id?projectId=<%=rs.getInt("projectId") %>">delete</a></td>
   </tr>
   
   <%} %>
   </table>
</body>
</html>