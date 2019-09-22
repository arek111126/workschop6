<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 16.09.19
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form:form method="post" action="/register" modelAttribute="user">
    <form:errors path="*"/>
    <table>
        <tr>
            <th>Imie</th>
            <td><form:input path="firstName"></form:input></td>

        </tr>
        <tr>
            <th>Nazwisko</th>
            <td><form:input path="lastName"></form:input></td>
        </tr>
        <tr>
            <th>email</th>
            <td><form:input path="email"></form:input></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><form:input path="password"></form:input></td>
        </tr>

    </table>
    <button type="submit">Zarejstruj</button>
</form:form>
</body>
</html>
