<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 22.09.19
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<form:form method="post" action="/createNewMessage" modelAttribute="message">
    <label for="message">Treść wiadomości</label>
    <form:hidden path="sender" value="${message.sender.id}"/>
    <form:input path="message"></form:input>
    <form:select path="receiver" items="${allUsers}" itemValue="id" itemLabel="lastName"/>
    <button type="submit">wyślij</button>
</form:form>
</body>
</html>
