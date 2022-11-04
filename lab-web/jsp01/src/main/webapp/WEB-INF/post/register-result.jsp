<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포스팅 결과</title>
<style>
    h2{margin-left:118px;}
    div{margin:16px;}
    label{
        font-weight: bold;
        display: inline-block;
        width: 72px;
        text-align: right;
        padding-right: 8px;
        vertical-align: middle;
    }
    input{
        width: 200px;
        height: 32px;
        padding-left: 8px;
    }
    textarea{
        width: 196px;
        height: 120px;
        padding: 8px;
    }
</style>
</head>
<body>
    <h2>포스팅 결과</h2>
    
        <div>
            <label>번호</label>
            <input type="number" value="${ post.id }" readonly/>
        </div>
        <div>
            <label>제목</label>
            <input type="text" value="${ post.title }" readonly/>
        </div>
        <div>
            <label>본문</label>
            <textarea>${ post.content }</textarea>
        </div>
        <div>
            <label>작성 시간</label>
            <input type="datetime-local" value="${ post.createTime }" readonly/>
        </div>

</body>
</html>