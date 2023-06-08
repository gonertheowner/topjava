<jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.Meal"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Meal</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Edit meal</h2>
<form method="POST" action="meals">
    DateTime: <input type="datetime-local" name="dateTime" value="${meal.dateTime}"/><br/>
    Description: <input type="text" name="description" value="${meal.description}"/> <br/>
    Calories: <input type="number" name="calories" value="${meal.calories}"/> <br/>
    <input type="hidden" name="id" value="${meal.id}">
    <input type="submit" value="Save"/>
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>
