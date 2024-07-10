### 第 2 周
[实验 1](./week2/exp1/src/main/java/exp1/Exp1.java)

使用 `Apache Commons Math` 进行线性代数运算。给出任意二维数组 `arr1` 和 `arr2`，求它们的和、差、乘积。

[实验 2](./week2/exp2/src/main/java/exp2/Exp2.java)

实现求两个数的最小公倍数方法并使用 `Junit` 来进行测试。

[实验 3](./week2/exp3/src/main/java/exp3/Exp3.java)

使用正则表达式分别实现能够验证邮箱、手机号码、QQ 号的方法并使用 `Junit` 来进行测试。

### 第 3 周
[实验 1](./week3/exp1/src/main/java/exp1/Exp1.java)

实现程序打印出 `message_zh_CN.properties` 和 `message_en_US.properties` 两个资源文件的内容。

[实验 2](./week3/exp2/src/main/java/exp2/Exp2.java)

将下面学生信息分别使用 `DOM` 和 `StAX` 保存为 XML 文件，然后读取所写入的 XML 文件内容。

| 学号 | 姓名 | 性别 | 出生日期 | 专业 |
|-|-|-|-|-|
| 20210001 | 张三 | 男 | 2003/09/15 | 软件工程 |
| 20210002 | 李四 | 男 | 2004/08/20 | 软件工程 |
| 20210003 | 晓红 | 女 | 2005/03/25 | 软件工程 |
| 20210004 | 小鹿 | 女 | 2003/12/12 | 软件工程 |

[实验 3](./week3/exp3/src/main/java/exp3/Exp3.java)

将下面员工信息保存为 JSON 文件，然后读取所写入的 JSON 文件内容。

|id | name | gender | birth | dept |
|-|-|-|-|-|
|1 | 张三 | 男 | 1997/11/02 | 开发部 |
|2 | 大强 | 男 | 1989/06/11 | 营销部 |
|3 | 小王 | 男 | 1993/05/30 | 财务部 |
|4 | 小胖 | 女 | 1998/07/10 | 开发部 |
|5 | 李怡 | 女 | 2000/05/18 | 人事部 |

[实验 4](./week3/exp4/src/main/java/exp4/Exp4.java)

绘制一个矩形图，在矩形图中显示时间钟表，能够显示出时间的变化。

### 第 4 周
[实验 1](./week4/exp1/src/main/java/exp1/Exp1.java)

使用 Java 的图像技术为图片加上文字水印效果。

[实验 2](./week4/exp2/src/main/java/exp2/Exp2.java)

实现一个简单图像处理界面，有图像的旋转、倾斜、水平/垂直拼接、放大/缩小功能。

[实验 3](./week4/exp3/src/main/java/exp3/Exp3.java)

使用 `Apache POI` 制作一张考研准考证。

[实验 4](./week4/exp4/src/main/java/exp4/Exp4.java)

使用 `Executor` 并发框架计算 $1! + 2! + 3! + \cdots + 100!$。分别对并行方法和顺序方法计时，比较两种方法的耗时。

[实验 5](./week4/exp5/src/main/java/exp5/Exp5.java)

使用 `Fork/Join` 并发框架实现 $2000 \times 2000$ 的随机数矩阵加法和乘法运算，分别对并行方法和顺序方法计时，比较两种方法的耗时。

### 第 5 周
[实验 1](./week5/exp1/src/main/java/exp1/Exp1.java)

实现两个任务，一个用来向账户中存款，存入一个随机金额 $[0, \ 100)$，另外一个从同一账户中提款，提款一个随机金额 $[0, \ 100)$。当提款的数额大于账户的当前余额时，提款线程必须等待。不管什么时候，只要向账户新存入一笔资金，存储线程必须通知提款线程重新尝试。如果余额仍未达到提款的数额，那么提款线程必须继续等待新的存款。

[实验 2](./week5/exp2/src/main/java/exp2/Exp2.java)

使用 `Timer` 类、`ScheduleExecutorService` 类、`Quartz` 的 `CronTrigger` 触发分别实现每 `5` 秒向 TXT 文件写入当前时间并在屏幕打印出来。

### 第 6 周
[实验 1](./week6/exp1/src/main/java/exp1/Exp1.java)

设计一个专门应用于方法上的注解 `LoginMethodAnnotation`，被该注解声明的方法为用户登录方法。该注解创建两个参数注解，分别用于声明用户名和密码，并设置用户名和密码的默认值为 `admin` 和 `111111`。

设计登录 `Login` 类，该类有两个私有成员变量用户名和密码。分别实现无参构造方法、有参构造方法、`Getter` 方法、`Setter` 方法、`toString` 方法。

在方法上加带参数“张三”，`333333` 的 `LoginMethodAnnotation` 注解。利用反射创建 `Login` 的对象，然后将注解的内容设置为对象的值并将值打印出来。

[实验 2](./week6/exp2/src/main/java/exp2/Exp2.java)

设计 `Animal` 类，属性有 `name`、`age`，方法有 `Getter`、`Setter`、`shout`、`move`。用 `DOS` 命令将 `Animal.class` 打成 `animal.jar` 包。

设计 `Cat` 类和 `Dog` 类继承 `Animal` 类，重写 `shout` 和 `move` 方法并进行测试。

[实验 3](./week6/exp3/test/src/main/java/exp3/Exp3.java)

创建 `animal` 模块，该模块有个 `Animal` 接口，该接口有一个 `shout` 方法，创建两个实例 `Bird` 和 `Dog` 实现不同的 `shout` 方法，对外提供 `Animal` 接口隐藏实例类。

创建 `test` 模块，使用模块化的服务调用 `Animal` 接口隐藏实例类中的 `shout` 方法。

### 第 7 周
[实验 1](./week7/exp1/src/main/webapp/login.html)

创建 Java Web 项目，使用 HTML 和 CSS 设计登录和注册页面。

### 第 8 周
[实验 1](./week8/exp1/src/main/webapp/login.jsp)

实现用户登录注册程序。

设计实体模型 `User` 类储存用户信息，有 `id`、`username`、`password`。

实现登录页面 `login.jsp` 和登录成功页面 `login-success.jsp`。

实现注册页面 `register.jsp` 和注册成功页面 `register-success.jsp`，然后跳转到登录页面 `login.jsp`。

实现登录控制器 `LoginServlet` 完成请求控制，然后利用请求转发技术跳转到 `VerifyServlet` 对用户名和密码进行验证。

实现注册控制器 `RegisterServlet` 完成请求控制，若注册成功，则利用重定向技术跳转到页面 `register-success.jsp`。

设计 `JDBCUtils` 类，实现加载数据库驱动，建立数据库连接和关闭数据库连接。

用户登录时向数据库查询用户信息验证该用户的账号和密码是否正确。

[实验 2](./week8/exp2/src/main/webapp/input-triangle.jsp)

使用 JavaBean 计算三角形的面积和周长。

实现两个 JSP 页面 `input-triangle.jsp` 和 `output-triangle.jsp`。`input-triangle.jsp` 提供一个表单，用户可以通过表单输入三角形的三条边提交给 `output-triangle.jsp`。用户提交表单后，JSP 页面将计算三角形面积和周长的任务交给一个 JavaBean 去完成。

### 第 9 周
[实验 1](./week9/exp1/src/main/webapp/login.jsp)

在第 8 周实验 1 登录注册程序基础上实现以下功能：

实现用户信息增删改查页面，数据库使用 `MyBatis` 技术和 `Druid` 技术。

使用 `Filter` 过滤器实现统一全站编码。

使用 `Filter` 过滤器实现权限校验功能，当用户想进行个人资料修改时，必须先要通过合法登录之后才可以进行操作。

使用 `Listener` 监听实现监控用户登录网站主页上线和下线情况。

### 第 10 周
[实验 1](./week10/exp1/src/main/webapp/online-cake-shop.jsp)

实现简易网上蛋糕店页面，具体要求和功能如下：

前端使用 `Axios` 技术，数据库使用 `MyBatis` 技术和 `Druid` 技术。

设计蛋糕实体类，在数据库中建立蛋糕信息表。

点击查询蛋糕信息按钮后，从数据库中将所有蛋糕信息查询来并显示在 `online-cake-shop.jsp` 页面的表格内。

选择蛋糕复选框，点击购买蛋糕按钮后，将购买的蛋糕信息显示在网页下面并更新数据库剩余蛋糕信息。