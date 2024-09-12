题目

`ServletRequest` 和 `HttpServletRequest` 有什么关系？

答案

`ServletRequest` 是 Java 提供的请求对象的根接口，`HttpServletRequest` 是 `ServletRequest` 接口的子接口，是对 HTTP 协议封装的请求对象。

<br>

题目

获取请求参数通用的方式有哪些？

答案

`Map<String, String[]> getParameterMap()`：获取所有的请求参数。

`String getParameter(String name)`：根据请求参数名获取请求参数值。

`String[] getParameterValues(String name)`：根据参数名获取请求参数，返回字符串数组，针对一个请求参数名对应多个值的请求。

<br>

题目

POST 请求乱码的原因及解决方式？

答案

原因：

POST 请求参数是通过 `request` 的 `getReader` 方法来获取流中的数据，Tomcat 在获取流的时候采用的编码是 ISO-8859-1，而该字符集是不支持中文的。

解决方式：

页面设置的编码格式为 UTF-8。

把 Tomcat 在获取流数据之前的编码设置为 UTF-8，即在获取请求参数前添加代码 `request.setCharacterEncoding("UTF-8")`。

<br>

题目

请写出请求转发的代码。请求转发路径是否加项目路径？

答案

```Java
request.getRequestDispatcher("/资源路径").forward(request, response);
```

请求转发路径不需要加项目路径。

<br>

题目

请写出请求重定向的代码。

答案

```Java
resposne.sendRedirect("/项目路径/资源路径");
```

<br>

题目

在项目编写路径时，什么时候需要加项目路径，什么时候不需要加项目路径？

答案

若路径是给浏览器使用的，则需要加项目路径；若路径是给服务器使用的，则不需要加项目路径。

请求转发是服务器内部跳转，因此不需要加项目路径。

超链接、表单提交路径、重定向等需要加项目路径。