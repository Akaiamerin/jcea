<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册成功</title>
</head>

<body>
    <div>注册成功，即将跳转到登录页面</div>
    <%
        response.setHeader("refresh", "1;URL=login.jsp");
    %>
</body>
</html>