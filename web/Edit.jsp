<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.11.2018
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

    <div style="text-align: center">
        <form action="edit" method="post">
            <p><label for="text1"><h2>Тема :</h2></label></p>
            <textarea name="text" id="text1" cols="50" rows="1"></textarea>
            <p><label for="text2"><h2>Текст повідомлення :</h2></label></p>
            <textarea name="text" id="text2" cols="50" rows="10"></textarea>

            <p><input type="reset" name="reset" value="Очистити"><input type="submit" name="submit" value="Відправити"></p>


        </form>
    </div>

</body>
</html>
