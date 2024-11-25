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
ResultSet  rs=(ResultSet)request.getAttribute("resultSet");
rs.next();
%>
<form action="update-project" method="post">
<input type="number" name="projectId" value="<%=rs.getInt("projectId") %>" readonly="readonly">
<input type="text" name="projectName" value="<%= rs.getString("projectName")%>">
<input type="number" name="projectBudget" value="<%= rs.getInt("projectBudget")%>">
<input type="text" name="projectDomain" value="<%= rs.getString("projectDomain")%>">
<input type="text" name="projectCountry" value="<%= rs.getString("projectCountry")%>">
<input type="submit" value="update">
</form>
</body>
</html>