<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/mygym/comment/create/vv" method="get">
    	검색할 헬스장:<input type="text" name="commentGcontent">
    	게시글 번호 :<input type="text" name="articleGnum">
    	게시글 번호 :<input type="text" name="userNickname">
    	<input type="submit" value="검색">
    </form>
</body>
</html>