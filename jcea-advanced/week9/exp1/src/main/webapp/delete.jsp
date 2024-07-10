<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>删除用户信息</title>
</head>

<body>
    <form action="DeleteServlet" method="post" autocomplete="off">
        <div>
            <div>
                <span>用户名&emsp;</span>
                <input type="text" name="username" placeholder=" 请输入用户名">
            </div>
            <input type="submit" value="删除">
        </div>
    </form>
</body>
</html>