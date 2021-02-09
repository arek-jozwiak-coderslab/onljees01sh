<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach var="strt" items="${strstr}">
        <li>${strt}</li>
    </c:forEach>
</ul>
<form:form method="post" modelAttribute="student">
    <form:input path="firstName"/>
    <form:input path="lastName"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
