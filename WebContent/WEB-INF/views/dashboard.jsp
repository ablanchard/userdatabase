<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mes users</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-md-12">

<form method="POST" action="dashboard">
	<table class="table table-striped">
	<th>id</th>
	<th>firstName</th>
	<th>lastName</th>
	<c:forEach items="${users}" var="user">
	<tr>
		<td>${user.id}</td>
		<td>${user.firstName}</td>
		<td>${user.lastName}</td>
	</tr>
	</c:forEach>
		<tr>
			<td><input type="submit" value="+"/></td>
			<td><input type="text" name="firstName" /></td>
			<td><input type="text" name="lastName" /></td>
		</tr>
	</table>
</form>
</div>
</div>
</div>
</body>
</html>