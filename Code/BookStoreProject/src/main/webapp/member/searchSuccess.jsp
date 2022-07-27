<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="book.vo.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Book book = (Book)request.getAttribute("book");%>
				책 제목 : <%= book.getBtitle() %>
</body>
</html>