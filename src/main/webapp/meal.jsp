<%@ page import="ru.javawebinar.topjava.model.MealWithExceed" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.javawebinar.topjava.util.DateTimeUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }
    </style>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>User list</h2>
<table border=1>
    <c:forEach items="${eee}" var="num" >
        <jsp:useBean id="num" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
        <tr class = "exceeded">
            <td>${num.description}</td>
            <td><%=DateTimeUtil.toString(num.getDateTime())%></td>
            <td>${num.calories}</td>
            <td>${num.exceed}</td>
        </tr>
    </c:forEach>
</table>
<h1>"${num.calories}"</h1>
</body>
</html>
