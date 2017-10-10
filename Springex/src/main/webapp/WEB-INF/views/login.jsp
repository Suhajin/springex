<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 로그인 </h1>
<form action="./login" method="post">
<table border="1">
<tr>
<td>ID</td>
<td><input type="text" name="memberId"></td>
</tr>
<tr>
<td>PW</td>
<td><input type="text" name="memberPw"></td>
</tr>
</table>
<input type="submit" value="로그인">
</form>
</body>
</html>