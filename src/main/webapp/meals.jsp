<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<p><a href="meals?action=create">Add meal</a></p>
<table border="1" cellspacing="0" cellpadding="5" frame="1">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
    <jsp:useBean id="mealsTo" scope="request" type="java.util.List"/>
    <c:forEach items="${mealsTo}" var="mealTo">
        <tr>
            <c:set var="color" value="${mealTo.excess ? \"red\" : \"green\"}"/>
            <font color="${color}">
                <td><font color="${color}">${fn:replace(mealTo.dateTime,"T"," ")}</font></td>
                <td><font color="${color}">${mealTo.description}</font></td>
                <td><font color="${color}">${mealTo.calories}</font></td>
            </font>
            <td><a href="meals?action=update&id=${mealTo.id}">Update</a></td>
            <td><a href="meals?action=delete&id=${mealTo.id}">Delete</a></td>
                <%--<td><font color="${color}">${fn:replace(mealTo.dateTime,"T"," ")}</font></td>
                <td><font color="${color}">${mealTo.description}</font></td>
                <td><font color="${color}">${mealTo.calories}</font></td>
                <td><a href="meals?action=update&id=${mealTo.id}">Update</a></td>
                <td><a href="meals?action=delete&id=${mealTo.id}">Delete</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
