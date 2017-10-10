<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>memberList</h1>
	<table border="1">
	<thead>
	<tr>
	<th> NO</th>
	<th> ID</th>
	<th> name </th>
	</tr>
	<c:forEach var = "member" items="${list}">
	<tr>
	<td>${member.memberNo}</td>
	<td>${member.memberId}</td>
	<td>${member.memberName}</td>
	</tr>
	</c:forEach>
	</thead>
	</table>
</body>
</html>