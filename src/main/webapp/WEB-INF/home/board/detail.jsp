<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상세목록 테스트</h1>

<ul>
<li>${detail.title}</li>
<li>${detail.content}</li>
</ul>

<a href="/update/${detail.idx}">수정</a>
<a href="/delete/${detail.idx}">삭제</a>

</body>
</html>