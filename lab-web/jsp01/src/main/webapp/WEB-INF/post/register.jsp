<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포스트 작성</title>
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
    #submit{
        width: 80px;
        margin: 16px 0 0 160px;
    }
</style>

</head>
<body>
    <h2>포스트 작성</h2>
    
    <form method="post">
        <div>
            <label>번호</label>
            <input type="number" name="id" placeholder="글 번호를 입력하세요."/>
        </div>
        <div>
            <label>제목</label>
            <input type="text" name="title" placeholder="글 제목을 입력하세요."/>
        </div>
        <div>
            <label>본문</label>
            <textarea name="content" placeholder="글 내용을 입력하세요."></textarea>
        </div>
        <div>
            <label>작성 시간</label>
            <input type="datetime-local" name="createTime" value="글 내용을 입력하세요."/>
        </div>
        <input id="submit" type="submit" value="등록"/>
    </form>
</body>
</html>