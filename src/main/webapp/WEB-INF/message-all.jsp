<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 21.09.19
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<a href="/createNewMessage">utwórz nową wiadomość</a>
<h2>Wiadomości Odebrane</h2>

<table border="1px solid black">
    <tr>
        <th>nadawca</th>
        <th>czy odczytana</th>
        <th>akcja</th>
    </tr>
    <c:forEach items="${recivedMessage}" var="message">
        <tr>
            <td>wiadomosc od: ${message.sender.firstName} ${message.sender.lastName}</td>
            <td>
                <c:choose>
                    <c:when test="${message.readed == 0}">Nie</c:when>
                    <c:when test="${message.readed == 1}">Tak</c:when>
                    <c:otherwise></c:otherwise>
                </c:choose>
            </td>
            <td><a href="/showReceivedMessage?id=${message.id}">wyświetl wiadomosc</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<h2>Wiadomości wysłane</h2>
<table border="1px solid black">
    <tr>
        <th>do kogo wysłana</th>
        <th>akcje</th>
    </tr>
    <c:forEach items="${sendedMessage}" var="message">
        <tr>
            <td>wiadomosc wyslana do: ${message.receiver.firstName} ${message.receiver.lastName} </td>
            <td><a href="/showSendedMessage?id=${message.id}">wyświetl wiadomość</a></td>
        </tr>

    </c:forEach>

</table>


</body>
</html>
