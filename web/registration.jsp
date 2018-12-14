<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.12.2018
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="post">

    <p><label>Введіть Ваш логін:<input type="text" name="login" required size="30" maxlength="16"></label></p>
    <p><label>Введіть Ваш пароль:<input type="text" name="password" required size="30" maxlength="16"></label></p>
    <p>посада Автор</p>
    <p><input type="submit" name="submit" value="Зареєструватись"></p>

</form>

</body>
</html>
