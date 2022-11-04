<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL</title>
</head>
<body>
    <h1>Form 제출 페이지</h1>
    
    <form action="12_result.jsp" method="get">
        <div>
            <input type="text" name="username" placeholder="사용자 이름" autofocus/>
        </div>
        <div>
            <select name="color">
                <option value="r">Red</option>
                <option value="g">Green</option>
                <option value="b">Blue</option>
            </select>
        </div>
        <div>
            <input type="submit" value="전송"/>
        </div>
    </form>
</body>
</html>