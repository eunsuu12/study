<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div>
        <h1>회원 가입 페이지</h1>
        
        <nav>
            <ul>
                <li>
                    <a href="/jsp02">메인 페이지</a>
                </li>
                <li>
                    <a href="/jsp02/user/list">목록 페이지</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <!-- form의 action 속성: 요청을 보내는 주소. 
            생략된 경우에는 현재 페이지로 요청을 보냄.-->
            <form method="post">
                <div>
                    <input type="text" name="userName" placeholder="아이디" required autofocus />
                </div>
                <div>
                    <input type="text" name="password" placeholder="비밀번호" required autofocus />
                </div>
                <div>
                    <input type="text" name="email" placeholder="이메일" required />
                </div>
                <div>
                    <input type="submit" value="가입하기" />
                </div>
            </form>
        </main>
    </div>
</body>
</html>