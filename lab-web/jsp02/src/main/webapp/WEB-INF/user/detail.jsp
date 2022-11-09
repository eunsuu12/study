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
        <h1>USER 상세 페이지</h1>
        
        <nav>
            <ul>
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${mainPage }">메인 페이지</a>
                </li>
                <li>
                    <c:url var="userListPage" value="/user/list"></c:url>
                    <a href="${userListPage }">USER 목록</a>
                </li>
                <li>
                    <c:url var="userModifyPage" value="/user/modify">
                        <c:param name="id" value="${user.id }"></c:param>
                    </c:url>
                    <a href="${userModifyPage }">회원 정보 수정</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <form method="post">
                <div>
                    <label for="id">No</label>
                    <input id="id" type="text" value="${user.id }" readonly />
                </div>
                <div>
                    <label for="userName">ID</label>
                    <input id="userName" type="text" value="${user.userName }" readonly />
                </div>
                <div>
                    <label for="password">PW</label>
                    <input id="password" type="text" value="${user.password }" readonly />
                </div>
                <div>
                    <label for="email">Mail</label>
                    <input id="email" type="text" value="${user.email }" readonly />
                </div>
                <div>
                    <label for="points">Point</label>
                    <input id="points" type="text" value="${user.points }" readonly />
                </div>
            </form>
        </main>
    </div>
</body>
</html>