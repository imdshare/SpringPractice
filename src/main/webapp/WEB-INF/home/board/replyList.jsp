<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<c:forEach var="re" items="${replyList }">
	<ul class="reply-item">
		<li>${re.writerId }</li>
		<li>${re.comment }</li>
	</ul>
</c:forEach>