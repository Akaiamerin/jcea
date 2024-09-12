题目

设计一个学生类，属性有姓名、性别、年龄，方法有无参构造方法、全参构造方法、`Getter` 方法、`Setter` 方法。

创建一个学生对象，给该对象的三个成员变量赋值。

使用 `ObjectOutputStream` 将对象保存到文件中。

使用 `ObjectInputStream` 从文件中获取对象。

答案

[Demo1.java](./src/day12/demo1/Demo1.java)

<br>

题目

键盘输入一行字符串，使用 `PrintStream` 将该字符串保存到文件中。

答案

[Demo2.java](./src/day12/demo2/Demo2.java)

<br>

题目

创建客户端，向服务端发送一条信息：“你好，世界！”

创建服务端，接收这条信息，输出到控制台。 

答案

[Client.java](./src/day12/demo3/Client.java)

[Server.java](./src/day12/demo3/Server.java)

<br>

题目

客户端向服务端发送信息，发送完毕后，服务端要向客户端发送一条反馈信息，客户端收到反馈信息后输出到控制台，两端结束。

答案

[Client.java](./src/day12/demo4/Client.java)

[Server.java](./src/day12/demo4/Server.java)

<br>

题目

文件上传。

服务端可以接受多个客户端的连接。

客户端上传文件到服务器端。

服务端需要反馈上传状态（成功或失败）给客户端。

答案

[Client.java](./src/day12/demo5/Client.java)

[Server.java](./src/day12/demo5/Server.java)

<br>

题目

文件下载。

服务端可以接受多个客户端的连接。

当接收到客户端的连接请求后，把一张图片传回给客户端。

答案

[Client.java](./src/day12/demo6/Client.java)

[Server.java](./src/day12/demo6/Server.java)

<br>

题目

设计一个皇帝类，要求任何地方拿到的皇帝对象都是相同的对象。分别使用饿汉式单例设计模式和懒汉式单例设计模式实现。

答案

[Demo7.java](./src/day12/demo7/Demo7.java)

<br>

题目

设计一个类表示公司的公用车。公司固定只有 `3` 辆车。使用多例模式进行设计，使获取车的对象总是固定的（`3` 个中的任意一个）。

答案

[Demo8.java](./src/day12/demo8/Demo8.java)