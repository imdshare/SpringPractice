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
<a href="/home/1">리스트</a>

<c:forEach var="test" items="${list}" varStatus="status" begin="0" end="10" step="1" >
	<ul>
		<li>${status.index+1 }</li>
		<li><a href="/test/${test.idx}">${test.title }</a></li>
		<li>${test.writer }</li>
		<li>${fn:substring(test.reg_date,0,10) }</li>
		<li>${fn:substring(test.edit_date,0,10) }</li>
	</ul>
</c:forEach>

<div class="pagging">
	<c:forEach begin="${page.from }" end="${page.to }" var="item" step="1">
				<a href="/home/${item }">${item }</a>
	</c:forEach>
</div>

<!-- <form action="/search.do"> -->
<!-- 	<input name="keyward" type="text" placeholder="검색어를 입력해주세요"> -->
<!-- 	<button type="submit">검색</button> -->
<!-- </form> -->


</body>

<style>

ul {

display:flex;
list-style: none;
}

li {
padding: 8px;
border: 1px solid #777;
}
</style>
</html>