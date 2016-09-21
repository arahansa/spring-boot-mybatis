<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title> Happy WOrld </title>
</head>
<body>
hello world map

<c:forEach items="${list }" var="item">
	${item.ID } , ${item.NAME } , ${item.PHONE } , ${item.CREATIONTIME }  <br>	
</c:forEach>

</body>
</html>