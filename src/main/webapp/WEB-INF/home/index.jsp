<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test Home</h1>
<a href="/test/write.do">글쓰기</a>

<ul>
	<li>번호</li>
	<li>제목</li>
	<li>작성자</li>
	<li>등록일</li>
	<li>수정일</li>
</ul>


<c:forEach var="test" items="${list}" varStatus="status" begin="1" end="10" step="1" >
	<ul>
		<li>${status.index }</li>
		<li><a href="/test/${test.idx}">${test.title }</a></li>
		<li>${test.writer }</li>
		<li>${fn:substring(test.reg_date,0,10) }</li>
		<li>${fn:substring(test.edit_date,0,10) }</li>
	</ul>
</c:forEach>


</body>
</html>