<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 파일 업로드 폼</h1>
<form method="post" enctype="multipart/form-data">
	<div> 파일제목 : <input type="text" name="fileTitle"></div>
	<div> 파일 : <input type="file" name="file"></div>
	<div> <input type="submit" value="제출"></div>
</form>
</body>
</html>