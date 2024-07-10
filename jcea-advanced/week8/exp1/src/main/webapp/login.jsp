<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录</title>
</head>

<body>
    <form action="LoginServlet" method="post" autocomplete="off">
        <div>
            <div>
                <span>用户名&emsp;</span>
                <input type="text" name="username" placeholder=" 请输入用户名">
            </div>
            <div>
                <span>密码&emsp;&emsp;</span>
                <input type="password" name="password" placeholder=" 请输入密码">
            </div>
            <input type="button" value="注册" onclick="window.location.href='register.jsp'">
            <input type="submit" value="登录">
        </div>
    </form>
</body>
</html>