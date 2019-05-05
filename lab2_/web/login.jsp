<%--
  Created by IntelliJ IDEA.
  User: DucTran
  Date: 1/19/2019
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div>
        <h1> Please write down your username and your password</h1>
        <form method="post" action ="login">

            <input type="text" name = "username" value = "Username">
            <input type="text" name = "password" value = "Password">
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
