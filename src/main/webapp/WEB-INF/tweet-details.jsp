<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 21.09.19
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tweet detail</title>
</head>
<body>
<h1>Dane szczegolowe</h1>
Tresc : ${currentTweet.text}
Data utworzenia: ${currentTweet.created} </br>
utworzone przez: ${user.firstName} ${user.lastName} </br>

komentarze:
<br>
<br>
<c:forEach items="${commentList}" var="comment">
    komentarz ${id}: ${comment.text}  autor: ${comment.user.firstName} ${comment.user.lastName}  <br> <br>

</c:forEach>
Dodaj nowy komentarz
<form:form method="post" action="/addcomment" modelAttribute="comment">
    <form:hidden path="tweet" value="${comment.tweet.id}"/>
    <form:hidden path="user" value="${comment.user.id}"/>
    <label for="text">text</label>
    <form:input path="text" id="text"></form:input><br>

    <button type="submit">Dodaj komentarz</button>
</form:form>
</body>
</html>
