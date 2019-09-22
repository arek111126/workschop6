<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 21.09.19
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>Moje tweety</h1>
<c:forEach items="${userTweets}" var="tweet">
    treść tweeta: ${tweet.text}  <a href="/tweetDetail?id=${tweet.id}">szczegóły</a> </br>
</c:forEach>
</body>
</html>
