题目

什么是会话？什么是会话跟踪技术？

答案

一次会话：当打开浏览器发送第一次请求开始，直到有一方断开，整个过程称为一次会话。

会话跟踪：服务器需要识别多次请求是否来自于同一浏览器，以便在同一次会话的多次请求间共享数据。

<br>

题目

会话跟踪技术有哪两种实现？

答案

Cookie：客户端会话跟踪技术。

Session：服务端会话跟踪技术。

<br>

题目

HTTP 协议中 Cookie 的实现是基于哪个请求头和响应头？

答案

请求头：`cookie`。

响应头：`set-cookie`。

<br>

题目

Cookie 用于设置存活时间的方法 `setMaxAge` 参数有哪些取值？分别表示什么含义？

答案

`setMaxAge` 接收一个 `int` 类型的参数，该参数有以下取值：

负数：默认值，浏览器将 Cookie 数据存储到内存中。

零：浏览器立即删除 Cookie 数据。

正数：浏览器会将数据持久化存储，正数表示的是存储的时长（单位是秒）。

<br>

题目

同一次会话中，执行 `request.getSession` 获取到的是否是同一个 `HttpSession` 对象？为什么？

答案

是同一个 `HttpSession` 对象。

第一次调用 `request.getSession` 方法时，Tomcat 会创建 `HttpSession` 对象并生成一个唯一的 id。然后将该 id 以 `set-cookie: JSESSIONID=id` 响应给浏览器。同一次会话第二次请求时会携带 `cookie: JSESSIONID=id`，而 Tomcat 会根据该 id 查找 `Session` 对象，若存在，则直接返回，因此同一次会话获取多次 `HttpSession` 对象肯定是同一个。

<br>

题目

什么是钝化？什么是活化？

答案

钝化：服务器正常关闭时，会将 `Session` 对象序列化存储到文件中。

活化：再次启动服务器时，会将之前序列化的文件进行反序列化并存储到内存中，生成一个 `Session` 对象。