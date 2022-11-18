<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Spring 2</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" 
        rel="stylesheet" 
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" 
        crossorigin="anonymous" />
</head>
<body>

<div class="container-fluid">
    
    <header class="my-2 p-4 text-center text-bg-secondary">
        <h1>Spring MVC &amp; MyBatis</h1>
        <h2>회원 목록 페이지</h2>
    </header>
    
    <nav>
        <ul class="nav bg-light">
            <li class="nav-item">
                <c:url var="mainPage" value="/"></c:url>
                <a class="nav-link active" href="${ mainPage }">메인 페이지</a>
            </li>
            <li class="nav-item">
                <c:url var="userCreatePage" value="/user/create"></c:url>
                <a class="nav-link active" href="${ userCreatePage }">회원 가입</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">LINK 3</a>
            </li>
        </ul>
    </nav>
    
    <main class="my-2">
        <div class="bg-light my-2 p-2">
            <c:url var="userSearchPage" value="/user/search"></c:url>
            <form action="${ userSearchPage }" method="get">
                <div class="row">
                    <div class="col-4">
                        <select class="form-control" name="type">
                            <option value="i">아이디</option>
                            <option value="e">이메일</option>
                            <option value="ie">아이디 + 이메일</option>
                        </select>
                    </div>
                    <div class="col-6">
                        <input class="form-control" 
                            type="text" name="keyword" placeholder="검색어" required autofocus />
                    </div>
                    <div class="col-2">
                        <input class="form-control btn btn-outline-success" type="submit" value="검색" />
                    </div>
                </div>
            </form>
        </div>
        
        <div class="card">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>아이디</th>
                        <th>이메일</th>
                        <th>포인트</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${ list }">
                            <tr>
                                <td>${ user.id }</td>
                                <td>
                                    <c:url var="userDetailPage" value="/user/detail">
                                        <c:param name="id" value="${ user.id }" />
                                    </c:url>
                                    <a href="${ userDetailPage }">${ user.username }</a>
                                </td>
                                <td>${ user.email }</td>
                                <td>${ user.points }</td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
    
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" 
    crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" 
    integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" 
    crossorigin="anonymous"></script>
</body>
</html>