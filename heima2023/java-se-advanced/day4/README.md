题目

```Java
double[] arr = {0.1, 0.2, 2.1, 3.2, 5.56, 7.21};
```

使用 `BigDecimal` 类型的变量分别求总和、平均值。

答案

[Demo1.java](./src/day4/demo1/Demo1.java)

<br>

题目

```Java
int[] arr = {1, 332, 43, 25, 3324, 34, 335, 4, 45, 2, 43, 52, 54};
```

使用 `Arrays.toString` 方法输出数组。

使用 `Arrays.sort` 方法数组进行升序排序。

使用 `Arrays.toString` 方法输出排序后的数组。

答案

[Demo2.java](./src/day4/demo2/Demo2.java)

<br>

题目

设计员工类，有以下成员属性：

姓名（`String` 类型）。

性别（`Character` 类型）。

年龄（`Integer` 类型）。

身高（`Double` 类型）。

婚否（`Boolean` 类型）。

从控制台输入数据，数据要求全部使用 `String` 类型接收。

创建学员对象，将所有数据转换后存储到这个对象中，最后输出该对象的所有属性。

答案

[Demo3.java](./src/day4/demo3/Demo3.java)

<br>

题目

键盘输入一个字符串，字符串包含一个学生的姓名、性别、年龄，身高信息。信息以中划线（`-`）分隔。

设计学生类，属性有姓名、性别、年龄，身高，将上述字符串转换为学生对象，将对象的属性信息输出到控制台。

答案

[Demo4.java](./src/day4/demo4/Demo4.java)

<br>

题目

创建一个 `Collection` 类型的集合，存储下面的字符串：

```Java
"《JavaEE 企业级开发指南》"
"《Oracle 高级编程》"
"《MySQL 从入门到精通》"
"《Java 架构师之路》"
```

使用迭代器遍历所有元素并输出。

使用迭代器遍历所有元素，筛选书名小于 `15` 个字符的元素并输出。

使用迭代器遍历所有元素，筛选书名中包含 `Java` 的元素并输出。

若书名中包含 `Oracle`，则删掉此书，然后遍历集合并输出。

答案

[Demo5.java](./src/day4/demo5/Demo5.java)

<br>

题目

创建一个 `Collection` 类型的集合，存储下面的分数信息：

```Java
88.5, 39.2, 77.1, 56.8, 89, 99, 59.5
```

使用增强 `for` 循环遍历所有元素并输出。

使用增强 `for` 循环遍历所有元素，输出不及格的分数。

使用增强 `for` 循环遍历所有元素，计算不及格的分数的数量、平均分、最高分，输出计算的结果。

答案

[Demo6.java](./src/day4/demo6/Demo6.java)