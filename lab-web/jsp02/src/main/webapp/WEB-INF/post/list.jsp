<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP 2</title>
</head>
<body>
    <div>
        <h1>포스트 목록 페이지</h1>
        
        <nav> <!-- 웹 서버 내에서 이동 메뉴 -->
            <ul>
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${mainPage }">메인 페이지</a>
                </li>
                <li>
                    <c:url var="postCreatePage" value="/post/create"></c:url>
                    <a href="${postCreatePage }">포스트 작성</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>수정 시간</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${posts }">
                        <tr>
                            <td>${p.id }</td>
                            <td>
                                <c:url var="postDetailPage" value="/post/detail">
                                    <c:param name="id" value="${p.id }"></c:param>
                                </c:url>
                                <a href="${postDetailPage }">${p.title }</a>
                            </td>
                            <td>${p.author }</td>
                            <td>${p.modifiedTime }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
</body>
</html>