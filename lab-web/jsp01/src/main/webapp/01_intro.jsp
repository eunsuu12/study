<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>
    /* CSS 주석 */
</style>
</head>
<body>
    <!-- HTML/XML 주석 -->
    <script>
    /* JS 블록 주석*/
    // JS 인라인 주석
    </script>
    
    <%-- JSP 주석 --%>
    <%-- Servlet/JSP 동작 방식 
    Servlet: Server + Applet 합성어.
    (웹 서버에서 실행되는, 요청을 처리하는 작은 프로그램.)
        - 웹 서버가 클라이언트로부터 요청을 받았을 때
            동적으로 HTML 문서를 생성하기 위한 프로그램.
        - Java class로 작성.
        - Servlet의 생성과, Servlet 객체의 메서도 호출은 WAS가 담당.
            * 최초 요청-> Servlet 객체 생성->
                doGet/doPost 메서드를 호출-> 응답
            * 요청-> 생성된 Servlet 객체의 doGet/doPost 메서드를 호출
                -> 응답
                
    JSP: Java Server Page
        - Servlet은 순수한 Java코드이기 때문에 HTML을 작성하는 것이 힘듦.
        - HTML 형식의 문서에서 Java코드들이
            실행될 수 있또록 만든 Server-side 기술.
        - JSP의 동작 원리: jsp-> java-> calss-> 객체 생성-> 메서드 호출.
            * 최초 요청-> jsp를 서블릿 클래스(java)로 변환->
                컴파일(class)-> 객체 생성-> doGet/doPost 메서드를 호출
            * 요청-> 생성된 객체에서 메서드를 호출-> 응답
            
    JSP 구성 요소(태그)
        1. 지시문(directive): <%@ ... %>
            <%@ page...%>, <%@ include...%>, <%@ taglib...%>, ...
            JSP 설정.
        2. 선언문(declaration): <%! ... %>
            JSP가 Java파일로 변환될 때,
            필드(멤버 변수)와 메서드를 정의하는 코드.
        3. 스크립트릿(scriptlet): <% ... %>
            JSP가 Java로 변환될 때,
            _jspService(request, response)메서드 안에 포함되는 코드.
            지역변수 선언. 메서드 호출. 조건문. 반복문. ...
        4. 식, 표현식(expression): <%= ... %>
            JSP가 Java로 변환될 때, out.print() 메서드의 argument로 전달되는 값.
            HTML에 바로 삽입되는 값.
        5. 주석(comment)
    
    --%>
    
    <%  /*Java 블록 주석*/
    System.out.println("01_intro.jsp"); // Java 주석 
    %>
    
    <h1>첫번째 JSP(Java Server Page)</h1>
    
    <% LocalDateTime now= LocalDateTime.now(); %>
    <h2>서버 시간: <%= now.toString() %></h2>
    
    <%-- declaration(선언문) --%>
    <%!
    private final String username= "admin"; // 클래스의 필드
    
    // getter 메서드
    public String getUsername(){
        return this.username;
    }
    %>
    
    <h3>Username: <%= getUsername() %></h3>
    
    
</body>
</html>