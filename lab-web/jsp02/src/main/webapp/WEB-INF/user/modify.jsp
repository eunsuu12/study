<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP 2</title>
</head>
<body>
    <div>
        <h1>회원 정보 수정 페이지</h1>
        
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
                    <c:url var="userDetailPage" value="/user/detail">
                        <c:param name="id" value="${user.id }"></c:param>
                    </c:url>
                    <a href="${userDetailPage }">회원 정보</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <form id="postForm"> <!-- action: 제출(submit) 주소. 기본값은 현재 페이지 주소.
            , method: 제출 방식. 기본값은 'get' -->
                <div>
                    <label for="id">No</label>
                    <input id="id" type="text" name="id" value="${user.id }" readonly />
                </div>
                <div>
                    <label for="userName">ID</label>
                    <input id="title" type="text" name="userName" value="${user.userName }" readonly/>
                </div>
                <div>
                    <label for="password">PW</label>
                    <input id="password" type="text" value="${user.password }" required autofocus/>
                </div>
                <div>
                    <label for="email">Mail</label>
                    <input id="email" type="text" value="${user.email }" required/>
                </div>
                <div>
                    <label for="points">Point</label>
                    <input id="points" type="text" name="points" value="${user.points}" readonly/>
                </div>
                <div>
                    <button id="btnDelete">삭제</button>
                    <button id="btnUpdate">수정 완료</button>
                    <!-- form안에서 작성된 버틀들은 form의 action주소로 method 방식의 요청을 보냄. -->
                </div>
            </form>
        </main>
    </div>
    
    <c:url var="userDeletePage" value="/user/delete"></c:url>
    <c:url var="userUpdatePage" value="/user/modify"></c:url>

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
            form.action= '${userDeletePage}';
            form.method= 'post';
            form.submit();
        }
    });
    
    const btnUpdate= document.querySelector('#btnUpdate');
    btnUpdate.addEventListener('click', function(event){
        event.preventDefault();
        const title= document.querySelector('#password').value;
        const content= document.quertSelector('#email').value;
        if(title== ''||content== ''){
            alert('비밀번호와 메일주소를 입력해주세요.');
            return;
        }
        form.action= '${userModifyPage}';
        form.method= 'post';
        form.submit();
        alert('수정 완료');
    });
    
    </script>
</body>
</html>