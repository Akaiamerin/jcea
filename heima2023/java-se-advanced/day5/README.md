题目

栈结构、队列结构、数组结构、链表结构的特点。

答案

栈：先进后出。

队列：先进先出。

数组：查询快，增删慢。

链表：查询慢，增删快。

<br>

题目

创建一个 `ArrayList` 集合，添加 `5` 个整数，使用不同的方式遍历这些元素。

普通 `for` 循环遍历。

迭代器遍历。

增强 `for` 循环遍历。

答案

[Demo1.java](./src/day5/demo1/Demo1.java)

<br>

题目

设计一个方法 `int getIndex(List<Integer> list, Integer target)`，实现返回 `target` 在 `list` 中第一次出现的索引，若不存在，则返回 `-1`。

答案

[Demo2.java](./src/day5/demo2/Demo2.java)

<br>

题目

设计一个学生类 `Student`，属性包含姓名、性别、年龄，方法包含无参构造方法、全参构造方法、`Getter` 方法、`Setter` 方法。

创建三个学生对象存入 `ArrayList` 集合中。

找出年龄最大的学生，然后将该对象的姓名变为“小猪佩奇”。

遍历集合输出对象属性信息。

答案

[Demo3.java](./src/day5/demo3/Demo3.java)

<br>

题目

创建一个 `HashSet` 集合，存储下面的数据：

```Java
"刘备", "关羽", "张飞", "刘备", "张飞"
```

输出集合大小。

使用迭代器遍历集合并输出。

使用增强 `for` 遍历集合并输出。

答案

[Demo4.java](./src/day5/demo4/Demo4.java)

<br>

题目

设计学生类 `Student`，属性有姓名、性别、年龄。

创建三个 `Student` 对象，分别设置下面的数据：

```Java
"张三", "男", 20
"李四", "男", 21
"张三", "男", 20
```

创建一个存储 `Student` 类型的 `HashSet` 集合，将上面的三个对象存储到集合中，要求集合中不能存储姓名、性别、年龄相同的元素。

使用增强 `for` 遍历集合，输出元素的属性值。

答案

[Demo5.java](./src/day5/demo5/Demo5.java)

<br>

题目

创建一个可以存储“整数”的 `LinkedHashSet` 集合。

存储整数 `20, 30, 50, 10, 30, 20`。

使用增强 `for` 遍历集合，输出大于 `25` 的元素。

答案

[Demo6.java](./src/day5/demo6/Demo6.java)