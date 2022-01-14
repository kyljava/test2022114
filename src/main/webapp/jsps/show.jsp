<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
	    <c:if test="${empty message}">
           <c:out value="邮件正在发送中"></c:out>
          </c:if>
          
          
          <c:if test="${ not  empty message}">
           <c:out value="${message}"></c:out>
          </c:if>
	</body>
</html>
