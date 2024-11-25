<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add-project" method="post">
<input type="number" placeholder="enter the projectId" name="projectId">
<input type="text" placeholder="enter the projectName" name="projectName">
<input type="number" placeholder="enter the projectBudget" name="projectBudget">
<input type="text" placeholder="enter the projectDomain" name="projectDomain">
<input type="text" placeholder="enter the projectCountry" name="projectCountry">
<input type="submit" value="add">

</form>
</body>
</html>