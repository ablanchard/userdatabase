<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mes users</title>
</head>
<body>
<table>
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
</table>
</body>
</html>