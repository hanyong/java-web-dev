<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
<%
String key = request.getParameter("key");
String value = System.getProperty(key);
request.setAttribute("value", value);
%>
<app:hello value="${value}"/>
</body>
</html>
