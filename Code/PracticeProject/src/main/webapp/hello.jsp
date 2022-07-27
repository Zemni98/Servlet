<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	request.setCharacterEncoding("UTD-8");
	String name = request.getParameter("userName"); %>
	이것은 소리없는 아우성!!
	<br>
	<br>
	받은 데이터는 : <%= name %>

</body>
</html>