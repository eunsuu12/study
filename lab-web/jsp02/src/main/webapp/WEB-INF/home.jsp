<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MVC</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>">
</head>
<body>
<div>

    <div>
        <h1>메인 페이지</h1>
    </div>
    
    <div>
        <ul>
            <li>
                <a href="post/list">포스트 전체 목록</a>
            </li>
            <li>
                <a href="user/list">USER 전체 목록</a>
            </li>
        </ul>
    </div>
    
</div>
</body>
</html>