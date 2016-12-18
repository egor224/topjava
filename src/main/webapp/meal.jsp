<%@ page import="ru.javawebinar.topjava.model.MealWithExceed" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
    <style>
        .normal {
            collor: green;
        }

        .exceeded {
            collor: red;
        }
    </style>
</head>
<body>
<% List<MealWithExceed> list = (List<MealWithExceed>) request.getAttribute("eee");
%>
<h2><a href="index.html">Home</a></h2>
<h2>User list</h2>
<table border=1>
    <c:forEach var="num" items="${eee}">
        <tr>
            <jsp:useBean id="num" scope="page" type=""
            <td>${num.getDescription()}</td>
            <td>${num.getDateTime()}</td>
            <td>${num.getCalories()}</td>
            <td>${num.getCalories()}</td>
        </tr>
    </c:forEach>
</table>
<h1>"<%=list.get(0).getCalories()%>"</h1>
</body>
</html>
