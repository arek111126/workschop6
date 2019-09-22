<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 21.09.19
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>Szczegóły wiadomości</h1>

treść : ${message.message}
stworzona : ${message.created};
wysłana do : ${message.receiver.firstName} ${message.receiver.lastName}
</body>
</html>
