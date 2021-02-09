<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Publisher</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.publisher.name}</td>
            <td>
                <a href="<c:url value="/book/confirm?id=${book.id}"/>">usuń</a>
                <a href="<c:url value="/book/edit?id=${book.id}"/>">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
