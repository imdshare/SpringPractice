<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<h1>상세목록 테스트</h1>

<ul>
	<li> 제목 : ${detail.title}</li>
	<li> 내용 : ${detail.content}</li>
</ul>

<a href="/update/${detail.idx}">수정</a>
<a href="/delete/${detail.idx}">삭제</a>


<!-- 댓글 -->
<div id= "reply">
	<div id = "in">
	
		<input id="reply-content"type ="text" placeholder="댓글 내용을 입력해주세요.">
		<button id="reply-submit" >등록</button>
	</div>
	
	<div id ="out">
	
	</div>


</div>


<!-- 댓글 등록 스크립트...? -->


<script>
$("#reply-submit").click(function(){
	alert('스크립트 먹을깜???');
});



</script>

</body>

<style>

ul {

display:block;
width: 12%;
list-style: none;
}

li {
padding: 8px;
border: 1px solid #777;
}
</style>
</html>