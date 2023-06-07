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
<table border="1" cellspacing="0" cellpadding="5" frame="1">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    <jsp:useBean id="mealsTo" scope="request" type="java.util.List"/>
    <c:forEach items="${mealsTo}" var="mealTo">
        <tr>
            <c:set var="color" value="${mealTo.excess == true ? \"red\" : \"green\"}"/>
            <c:set var="dateTime" value="${mealTo.dateTime}"/>
            <td><font color="${color}">${fn:replace(dateTime,"T"," ")}</font></td>
            <td><font color="${color}"><c:out value="${mealTo.description}"/></font></td>
            <td><font color="${color}"><c:out value="${mealTo.calories}"/></font></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
