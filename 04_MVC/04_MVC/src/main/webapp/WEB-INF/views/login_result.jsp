<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty vo} ">
			<h1>로그인 결과</h1>
			<ul>
				<li> 아이디 :${vo.id}</li>
				<li> 이름 : ${vo.name}</li>
				<li> 주소 : ${vo.addr}</li>
			</ul>
			<a href="index.jsp">메인 화면으로 이동</a>
		</c:when>
	
	
	<c:otherwise>
		<h1>로그인 실패. 다시 시도해주세요</h1>
		<a href=/login>로그인 창으로 이동</a>
	</c:otherwise>
	</c:choose>
</body>
</html>

