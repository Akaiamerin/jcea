<%@ page import="exp2.Triangle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Show Triangle</title>
</head>

<body>
    <jsp:useBean id="triangle" class="exp2.Triangle" scope="page"></jsp:useBean>
    <jsp:setProperty name="triangle" property="side1"/>
    <jsp:setProperty name="triangle" property="side2"/>
    <jsp:setProperty name="triangle" property="side3"/>
    <%
        String str = null;
        if (triangle.isTriangle() == false) {
            str = "非法三角形";
        }
        else {
            str = "面积：" + triangle.getArea() + " 周长：" + triangle.getCircumference();
        }
    %>
    <div><%=str%></div>
</body>
</html>