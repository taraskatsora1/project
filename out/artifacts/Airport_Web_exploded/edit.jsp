<jsp:useBean id="plane" scope="request" type="com.epam.Plane"/>
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Тарас
  Date: 11.04.2020
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Plane</title>
</head>
<body>
<h3>Edit plane</h3>
<form method="post">

    <input type="hidden" value="${plane.idPlanes}" name="id" />

    <label>liftingWeight</label><br>
    <input liftingWeight="liftingWeight" value="${plane.liftingWeight}" /><br><br>

    <label>maxDistance</label><br>
    <input maxDistance="maxDistance" value="${plane.maxDistance}"   /><br><br>

    <label>consumption</label><br>
    <input consumption="consumption" value="${plane.consumption}"   /><br><br>

    <label>numberPlaces</label><br>
    <input numberPlaces="numberPlaces" value="${plane.numberPlaces}"   /><br><br>

    <input type="submit" value="Send" />
</form>
</body>
</html>
