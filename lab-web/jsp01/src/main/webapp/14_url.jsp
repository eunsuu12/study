<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>
    <h1>JSTL &lt;c:url&gt;</h1>
    <ul>
        <li>
            <a href="12_result.jsp?color=r&username=admin">클릭</a>
        </li>
        <li>
            <c:url var="url1" value="12_result.jsp">
                <c:param name="color" value="r"></c:param>
                <c:param name="username" value="ad&min"></c:param>
            </c:url>
            <a href="${url1 }">클릭2</a>
        </li>
    </ul>
</body>
</html>