<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edycja książki: ${book.title}</h1>
<form:form method="post" modelAttribute="book" action="/book/update">
    <form:hidden path="id"/>
    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    <form:select path="author" items="${authors}" itemLabel="firstName" itemValue="id" />
    <form:input path="title"/>
    <input type="submit" value="Update">
</form:form>
</body>
</html>
