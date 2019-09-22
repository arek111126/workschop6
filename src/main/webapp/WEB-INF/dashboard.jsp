<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/usertweets">Moje tweety</a><br>

<c:forEach items="${tweetsList}" var="tweet">
    treść tweeta: ${tweet.text} </br>
</c:forEach>

<br>
<br>
<br>
Dodaj nowy wpis
<form:form method="post" action="/addtweet" modelAttribute="tweet">

    <label for="text">text</label>
    <form:input path="text" id="text"></form:input><br>

    <button type="submit">Dodaj</button>
</form:form>
<a href="/SentAndReceivedMessages">Moje wiadomości</a>

</body>
</html>
