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
		<input id="writerId"type ="hidden" value="admin"> <!-- 로그인 기능 구현 안했으니꺼 임시적으로... -->
		<input id="comment" type ="text" placeholder="댓글 내용을 입력해주세요." name ="comment"> 
		<input id="board_no" type ="hidden" name= "boardNo" value="${detail.idx }">
		<button id="reply-submit" onclick="addReply();">등록</button>
	</div>
	<div id ="out">
		
	</div>
</div>


<!-- 댓글 등록 스크립트...? -->


<script>


	getReply();

	
function addReply(){

	var comment = $("input[name='comment']").val();
	var boardNo = "${detail.idx }";
	var writerId = $("#writerId").val();

	if(comment == ""){
		alert('댓글 내용을 입력해주세요');
		return;
	}
		
	$.ajax({
		  url : "/addReply"
		, type : "POST"
		, data : {
			boardNo : boardNo,
			comment : comment,
			writerId : writerId
			
		} 
		, success: function(data) {
			alert('등록되었습니당');
			getReply();
			$("#comment").val("");
		}
		, error: function(data) {
			alert("오류가 발생했습니다 : " + data);
		}
	});
}


function getReply(){

	var boardNo = "${detail.idx }";
	$.ajax({
		  url : "/getReply"
		, type : "POST"
		, data : {
			boardNo : boardNo
		} 
		, success: function(data) {
			$("#out").html(data);
		}
		, error: function(data) {
			alert("오류가 발생했습니다 : " + data);
		}
	});
}


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