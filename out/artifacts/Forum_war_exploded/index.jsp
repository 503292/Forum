<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.11.2018
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<% String login = (String) session.getAttribute("user_login"); %>
<% String status = (String) session.getAttribute("status"); %>

<% if (status == null ) {status = "";} %>

<% if (login == null || "".equals(login)) { %>

<div style="text-align: center">


    <h1>Регістрація / Вхід</h1>
    <form action="/login" method="post" name="login">
        <p><label>Введіть Ваш логін:<input type="text" name="login" size="30" maxlength="16"></label></p>
        <p><label>Введіть Ваш пароль:<input type="password" name="password" size="30" maxlength="16"></label></p>

        <p><input type="submit" name="submit" value="Відправити"></p>

    </form>
    <%= status %>
    <form action="/registration.jsp">

        <button type="submit" value="Зареєструватись"> Зареєструватись</button>
    </form>


</div>


<% } else { %>
<div style="text-align: center">
    <h1>Ви зареєстровані як: <%= login %>
    </h1>
    <br>Для переходу на форум натисніть: <a href="forumPage.jsp">forum</a>
    <br>Для виходу з акаунта: <a href="/logout">Вийти</a>
</div>
<% } %>


</body>
</html>
