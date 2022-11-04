<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<Style>
    div{margin: 16px;}
</Style>
<title>JSP</title>
</head>
<body>
    <h1>연락처 등록 페이지</h1>
    
    <form method="post">
        <div>
            <label>이름</label>
            <input type="text" name="name" placeholder="이름"/>
        </div>
        <div>
            <label>번호</label>
            <input type="tel" name="phone" placeholder="번호"/>
        </div>
        <div>
            <label>메일</label>
            <input type="email" name="email" placeholder="메일"/>
        </div>
            <input type="submit" value="등록"/>
        
    </form>
</body>
</html>