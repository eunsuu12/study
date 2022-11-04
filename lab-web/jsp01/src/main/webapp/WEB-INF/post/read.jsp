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
    <h2>포스트 전체 목록</h2>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성 시간</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${ list }">
                <tr>
                    <td>${ p.id }</td>
                    <td>${ p.title }</td>
                    <td>${ p.createTime }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>