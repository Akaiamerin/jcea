<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Input Triangle</title>
</head>

<body>
    <form action="output-triangle.jsp" method="post" autocomplete="off">
        <div>
            <div>
                <span>边 1&emsp;</span>
                <input type="text" name="side1" placeholder=" 请输入边 1">
            </div>
            <div>
                <span>边 2&emsp;</span>
                <input type="text" name="side2" placeholder=" 请输入边 2">
            </div>
            <div>
                <span>边 3&emsp;</span>
                <input type="text" name="side3" placeholder=" 请输入边 3">
            </div>
            <input type="submit" value="计算面积和周长">
        </div>
    </form>
</body>
</html>