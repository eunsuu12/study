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
        <h2>회원 가입 페이지</h2>
    </header>
    
    <nav>
        <ul class="nav bg-light">
            <li class="nav-item">
            <c:url var="mainPage" value="/"></c:url>
                <a class="nav-link active" href="${mainPage }">메인 페이지</a>
            </li>
            <li class="nav-item">
                <c:url var="userListPage" value="/user/list"></c:url>
                <a class="nav-link active" href="${userListPage }">회원 목록 페이지</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">LINK 3</a>
            </li>
        </ul>
    </nav>
    
    <main> <!-- TODO: main content -->
        <div class="card p-4">
            <form method="post">
                <div class="my-4">
                    <label for="username" class="form-label">아이디</label>
                    <input id="username" class="form-control" type="text" name="username" required autofocus />
                </div>
                <div class="my-4">
                    <label for="password" class="form-label">비밀번호</label>
                    <input id="password" class="form-control" type="text" name="password" required />
                </div>
                <div class="my-4">
                    <label for="email" class="form-label">메일</label>
                    <input id="email" class="form-control" type="text" name="email" required />
                </div>
                <div class="my-4">
                    <input class="form-control btn btn-success" type="submit" value="회원 가입" />
                </div>
            </form>
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