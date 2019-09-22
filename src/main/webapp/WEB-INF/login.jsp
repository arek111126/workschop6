<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 15.09.19
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<h1>login page login</h1>


<c:if test="${not empty error}">Niepoprawne Dane !! spróbuj ponownie</c:if>


<form:form method="post" action="/login" modelAttribute="user">

    <table>
        <tr>
            <th>login</th>
            <td><form:input path="email"></form:input></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><form:password path="password"></form:password></td>
        </tr>
    </table>
    <button type="submit">login</button>
</form:form>

Nie posiadasz jeszcze konta ? Zarejstruj się klikając w link <a href="/register"> zarejstruj</a>

</body>
</html>
