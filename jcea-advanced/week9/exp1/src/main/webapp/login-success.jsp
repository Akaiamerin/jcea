<%@ page import="exp1.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录成功</title>
</head>

<body>
    <div>登录成功</div>
    <div>
        <input type="button" value="增加用户信息" onclick="window.location.href='insert.jsp'">
        <input type="button" value="删除用户信息" onclick="window.location.href='delete.jsp'">
        <input type="button" value="修改用户信息" onclick="window.location.href='update.jsp'">
        <input type="button" value="查询用户信息" onclick="window.location.href='select.jsp'">
    </div>
    <%
        List<User> onlineUserList = (List<User>) application.getAttribute("onlineUserList");
    %>
    <%for (int i = 0; i < onlineUserList.size(); i++) {%>
    <%=onlineUserList.get(i).getUsername()%>
    <%}%>
    <%--    <c:forEach items="<%=onlineUserList%>" var="user">--%>
    <%--        ${user.username}<br/>--%>
    <%--    </c:forEach>--%>
</body>
</html>