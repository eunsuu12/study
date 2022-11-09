<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP 2</title>
</head>
<body>
    <div>
        <c:if test="${searchPage }">
            <h1>USER 검색 결과 페이지</h1> 
        </c:if>
        <c:if test="${not searchPage }">
            <h1>USER 목록 페이지</h1>        
        </c:if>
        
        <nav> <!-- 웹 서버 내에서 이동 메뉴 -->
            <ul>
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${mainPage }">메인 페이지</a>
                </li>
                <c:if test="${searchPage }">
                    <li>
                        <c:url var="userList" value="/user/list"></c:url>
                        <a href="${userList }">USER 목록 페이지</a>
                    </li> 
                </c:if>
                <li>
                    <c:url var="userCreatePage" value="/user/create"></c:url>
                    <a href="${userCreatePage }">회원 가입</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <div>
                <c:url var="userSearchPage" value="/user/search"></c:url>
                <form method="get" action="${userSearchPage }">
                    <select name="type">
                        <option value="id">ID</option>
                        <option value="e">EMAIL</option>
                        <option value="ide">ID + EMAIL</option>
                    </select>
                    <input type="text" name="keyword" placeholder="검색어" required />
                    <input type="submit" value="search" />
                </form>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>아이디</th>
                        <th>이메일</th>
                        <th>포인트</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${users }">
                        <tr>
                            <td>${u.id }</td>
                            <td>
                                <c:url var="userDetailPage" value="/user/detail">
                                    <c:param name="id" value="${u.id }"></c:param>
                                </c:url>
                                <a href="${userDetailPage }">${u.userName }</a>
                            </td>
                            <td>${u.email }</td>
                            <td>${u.points }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
</body>
</html>