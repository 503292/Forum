<%@ page import="static ua.servlet.LoginServlet.usersMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="ua.user.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.11.2018
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forum</title>
</head>
<body>

<header style="text-align: center">
    <div>

        <h1>Forum</h1>
        <% String login = (String) session.getAttribute("user_login"); %>
        <p>Ви зареєстровані як: <%=login %>
        </p>
        <p>Для виходу натисніть: <a href="/logout">Вийти</a></p>

    </div>
    <div>
        <form action="/edit" method="post">

            <p><input type="submit" name="submit" value="Нова стаття"></p>

        </form>
    </div>

</header>


<content>
    <div>
        <form action="/addArticles" method="post">

            <%--<p><input type="submit" name="submit" value="Нова стаття"></p>--%>

        </form>
        <% %>
    </div>
</content>

<div>
    <%  for(Map.Entry<String, User> e : usersMap.entrySet()) { %>
        <%String str =e.getKey(); %>
        <%User us =e.getValue();%>
        <%= str%>
        <%= us.getPass()%>
        <%= us.getLogin()%>
        <%= us.isAdmin()%>
    <%= " ..." %>
    <% } %>
</div>


</body>
</html>
