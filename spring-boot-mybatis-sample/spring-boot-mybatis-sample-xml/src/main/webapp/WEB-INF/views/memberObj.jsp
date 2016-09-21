<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title> Happy WOrld </title>
</head>
<body>
hello world obj

<c:forEach items="${list }" var="item">
	${item.id } , ${item.name } , ${item.phone } , ${item.creationtime } <br>	
</c:forEach>

</body>
</html>