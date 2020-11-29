<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정 테스트</h1>

<form action="/update" method="post">
	<input type="hidden" value="${detail.idx }" name="idx">
	<input type="hidden" value="${detail.writer }" name="writer">
	<input type="text" value="${detail.title}" name="title">
	<textarea name="content">${detail.content}</textarea>
	<button type="submit">수정</button>
</form>


</body>
</html>