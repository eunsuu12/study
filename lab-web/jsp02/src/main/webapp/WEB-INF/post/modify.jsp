<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP 2</title>
</head>
<body>
    <div>
        <h1>포스트 수정 페이지</h1>
        
        <nav>
            <ul>
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${mainPage }">메인 페이지</a>
                </li>
                <li>
                    <c:url var="postListPage" value="/post/list"></c:url>
                    <a href="${postListPage }">포스트 목록</a>
                </li>
                <li>
                    <c:url var="postDetailPage" value="/post/detail">
                        <c:param name="id" value="${post.id }"></c:param>
                    </c:url>
                    <a href="${postDetailPage }">포스트 상세</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <form id="postForm"> <!-- action: 제출(submit) 주소. 기본값은 현재 페이지 주소.
            , method: 제출 방식. 기본값은 'get' -->
                <div>
                    <label for="id">번호</label>
                    <input id="id" type="text" name="id" value="${post.id }" readonly />
                </div>
                <div>
                    <label for="title">제목</label>
                    <input id="title" type="text" name="title" value="${post.title }" required autofocus/>
                </div>
                <div>
                    <label for="content">내용</label>
                    <textarea id="content" name="content" rows="5" cols="80" required>${post.content }</textarea>
                </div>
                <div>
                    <label for="author">작성자</label>
                    <input id="author" type="text" value="${post.author }" readonly />
                </div>
                <div>
                    <button id="btnDelete">삭제</button>
                    <button id="btnUpdate">수정 완료</button>
                    <!-- form안에서 작성된 버틀들은 form의 action주소로 method 방식의 요청을 보냄. -->
                </div>
            </form>
        </main>
    </div>
    
    <c:url var="postDeletePage" value="/post/delete"></c:url>
    <c:url var="postUpdatePage" value="/post/modify"></c:url>

    <script>
    // HTML 요소를 찾음.
    const form= document.querySelector('#postForm');
    const btnDelete= document.querySelector('#btnDelete');
    
    btnDelete.addEventListener('click', function(event){
    	event.preventDefault(); // 이벤트 기본 처리방식이 실행되지 않도록 막음.
    	//-> 폼 양식이 서버로 제출되지 않도록 함.
    	
    	// 사용자에게 삭제 확인
    	const check= confirm('삭제하시겠습니까?');
    	console.log(check);
    	if(check){
    		form.action= '${postDeletePage}';
    		form.method= 'post';
    		form.submit();
    	}
    });
    
    const btnUpdate= document.querySelector('#btnUpdate');
    btnUpdate.addEventListener('click', function(event){
    	event.preventDefault();
    	const title= document.querySelector('#title').value;
    	const content= document.quertSelector('#content').value;
    	if(title== ''||content== ''){
    		alert('제목과 내용을 입력해주세요.');
    		return; // 이벤트 리스너 종료
    	}
        form.action= '${postModifyPage}';
        form.method= 'post';
        form.submit();
        alert('수정 완료');
    });
    
    </script>
</body>
</html>