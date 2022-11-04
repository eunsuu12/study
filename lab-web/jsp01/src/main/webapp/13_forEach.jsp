<%@page import="edu.web.jsp01.domain.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL</title>
    <style>
        th,td{width: 60px; text-align: center; padding: 4px;}
        th{font-size: 20px;}
        th:last-child, td:last-child {width: 200px; text-align: left;}
    </style>
</head>
<body>
    <h1>JSTL &lt;c:forEach&gt;</h1>
    
    <%
    // 리스트 아이템으로 사용할 더미 데이터~
    String[] sites= {"YouTube","Instagram","Facebook","Twitter"};
    
    // EL에서는 자바의 지역변수를 직접 접근할 수 없기 때문에,
    // pageContext, request, session, application에 속성으로 추가.
    pageContext.setAttribute("sites", sites);
    %>
    
    <h2>scriptlet</h2>
    <ul>
        <% for(String s: sites) { %>
        <li><%= s %></li>
        <% } %>
    </ul>
    
    <h2>JSTL &amp; EL</h2>
    <ul>
        <c:forEach var="site" items="${ sites }">
        <%--EL의 sites는 pageContext로 받은 sites--%> 
            <li>${ site }</li>
        </c:forEach>
    </ul>
    
    <h2>JSP 테이블 작성</h2>
    <%
    // 테이블 행 데이터로 사용할 더미 데이터
    ArrayList<Contact> list= new ArrayList<>();
    for(int i=0; i<5; i++){
        Contact c= new Contact("은수"+i, "0"+i+i+i, "user"+i+"@gmail.com");
        list.add(c);
    }
    
    // EL에서 ${contacts} 사용 위한
    pageContext.setAttribute("contacts", list);
    %>
    <table>
        <thead>
            <tr>
                <th>이름</th>
                <th>번호</th>
                <th>메일</th>
            </tr>
        </thead>
        <tbody>
            <% for(Contact c: list) { %>
                <tr>
                    <td><%= c.getName() %></td>
                    <td><%= c.getPhone() %></td>
                    <td><%= c.getEmail() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    
    <h2>JSTL &amp; EL 테이블 작성</h2>
    <table>
        <thead>
            <tr>
                <th>이름</th>
                <th>번호</th>
                <th>메일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${ contacts }">
                <tr>
                    <td>${ c.name }</td>
                    <td>${ c.phone }</td>
                    <td>${ c.email }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>