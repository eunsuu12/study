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
    <div>
        <c:if test="${searchPage }">
            <h1>포스트 검색 결과 페이지</h1> 
        </c:if>
        <c:if test="${not searchPage }">
            <h1>포스트 목록 페이지</h1>        
        </c:if>
        
        <nav> <!-- 웹 서버 내에서 이동 메뉴 -->
            <ul>
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${mainPage }">메인 페이지</a>
                </li>
                <c:if test="${searchPage }">
                    <li>
                        <c:url var="postList" value="/post/list"></c:url>
                        <a href="${postList }">목록 페이지</a>
                    </li> 
                </c:if>
                <li>
                    <c:url var="postCreatePage" value="/post/create"></c:url>
                    <a href="${postCreatePage }">포스트 작성</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <div>
                <c:url var="postSearchPage" value="/post/search"></c:url>
                <form method="get" action="${postSearchPage }">
                    <select name="type">
                        <option value="t">제목</option>
                        <option value="c">내용</option>
                        <option value="tc">제목 + 내용</option>
                        <option value="a">작성자</option>
                    </select>
                    <input type="text" name="keyword" placeholder="검색어" required />
                    <input type="submit" value="search" />
                </form>
            </div>
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
                    <c:forEach var="p" items="${list }">
                        <tr>
                            <td>${p.id }</td>
                            <td>
                                <c:url var="postDetailPage" value="/post/detail">
                                    <c:param name="id" value="${p.id }"></c:param>
                                </c:url>
                                <a href="${postDetailPage }">${p.title }</a>
                            </td>
                            <td>${p.author }</td>
                            <td>${p.modified_time }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
</body>
</html>