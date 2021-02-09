<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Czy jesteś pewien:
<a href="<c:url value="/book/all-list"/>">nie</a>
<a href="<c:url value="/book/delete/${param.id}"/>">tak</a>
</body>
</html>
