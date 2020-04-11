<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Тарас
  Date: 10.04.2020
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Planes List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
    <tr><th>ID</th><th>liftingWeight</th><th>maxDistance</th><th>consumption</th><th>numberPlaces</th></tr>
    <c:forEach var="plane" items="${planes}">
        <tr><td>${plane.idPlanes}</td>
            <td>${plane.liftingWeight}</td>
            <td>${plane.maxDistance}</td>
            <td>${plane.consumption}</td>
            <td>${plane.numberPlaces}</td>
            <td>
                <a href='<c:url value="/edit?id=${plane.idPlanes}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${plane.idPlanes}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
</body>
</html>
