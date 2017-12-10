<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="key" fragment="false"%>
<%
String value = System.getProperty(key);
%>
Hello JSP tag <%= value %>
