<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="drink">
    <div>
        <form:input path="name"/>
    </div>
    <div>
        <form:errors path="name"/>
    </div>
    <div>
        <form:input path="rating"/>
    </div>
    <div>
        <form:errors path="rating"/>
    </div>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
