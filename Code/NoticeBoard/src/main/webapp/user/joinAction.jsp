<%@page import="member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.dao.MemberDAO"
	import="member.vo.Member" import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
System.out.println("여기다");
<%-- 	<%
	String id = request.getParameter("userNAME");
	String pw = request.getParameter("userID");
	String name = request.getParameter("userPW");
	if (id == null || pw == null || name == null) {
		PrintWriter script = response.getWriter();
		System.out.println("여기까지는왔따");
		script.println("<script>");
		script.println("alert('빈칸을 확인해 주세요')");
		script.println("history.back()");
		script.println("</script>");
	} else {
		System.out.println("여기는 else");
		Member member = new Member();
		MemberDAO memberDAO = new MemberDAO();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
	}
	/* int result = memberDAO.join(member);
		
	if(result == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('서버오류')");
		script.println("history.back()");
		script.println("</script>");
	} else if(result == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 아이디가 존재합니다.')");
		script.println("history.back()");
		script.println("</script>");
	} else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('회원가입을 축하드립니다.')");
		script.println("location.href = '../index.jsp'");
		script.println("</script>");
	}
	} */
	%> --%>
</body>
</html>