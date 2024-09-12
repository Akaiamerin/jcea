题目

定义 `Student` 类。

```Java
public class Student {
    private String name;
    private Integer age;
    //公有、无参构造
    //公有、全参构造
    //公有、getter/setter 方法
    //......
    //普通成员方法
    public void show() {
        System.out.println("大家好，我叫" + name + "，我今年" + age + "岁");
    }
}
```

使用反射获取 `Student` 的 `Class` 对象。

使用反射获取并调用公有、全参构造方法，传入“张三”，20 两个参数。

使用反射获取并调用 `show` 方法。

答案

[Demo1.java](./src/day5/demo1/Demo1.java)

<br>

题目

现有集合 `List<Integer> list = new ArrayList<>()`，利用反射机制在这个泛型为 `Integer` 的 `List` 中存放一个 `String` 类型的对象。

答案

[Demo2.java](./src/day5/demo2/Demo2.java)

<br>

题目

按要求完成下面两个方法的方法体。

编写一个方法，此方法可以将 `obj` 对象中名为 `propertyName` 的属性的值设置为 `value`。

编写一个方法，此方法可以获取 `obj` 对象中名为 `propertyName` 的属性的值。

答案

[Demo3.java](./src/day5/demo3/Demo3.java)

<br>

题目

定义一个 `Person` 类，包含私有属性 `name`、`age`，无参构造方法、全参构造方法、`Getter` 方法、`Setter` 方法。

使用反射创建一个实例、调用全参构造方法初始化 `name`、`age`。使用反射调用 `setName` 方法对姓名赋值，不使用 `setAge` 方法直接使用反射方式对年龄赋值。

答案

[Demo4.java](./src/day5/demo4/Demo4.java)

<br>

题目

```Java
public class HelloWorld {
    public void show() {
        System.out.println("Hello World!");
    }
}
```

编写一个 Properties 格式的配置文件，配置文件内容如下：

```Markdown
className=com.itcast.test07.DemoClass
```

读取这个 Properties 配置文件，获得类的完整名称并加载这个类。

使用反射运行 `show` 方法。

答案

[Demo5.java](./src/day5/demo5/Demo5.java)

<br>

题目

编写程序，模拟 JUnit 的 `@Test` 注解。

答案

[Demo6.java](./src/day5/demo6/Demo6.java)

<br>

题目

执行下面的 SQL 脚本，完成相应的查询练习。

```SQL
CREATE TABLE student (
    id INT,
    name VARCHAR(20),
    age DATETIME,
    gender VARCHAR(1)
);
CREATE TABLE teacher (
    id INT,
    name VARCHAR(20)
);
CREATE TABLE course (
    id INT,
    name VARCHAR(20),
    teacher_id INT
);
CREATE TABLE score (
    student_id INT,
    course_id INT,
    score DECIMAL(4, 2)
);
INSERT INTO student (id, name, age, gender) VALUES (1, '赵雷', '1990-01-01', '男');
INSERT INTO student (id, name, age, gender) VALUES (2, '钱电', '1990-12-21', '男');
INSERT INTO student (id, name, age, gender) VALUES (3, '孙风', '1990-12-20', '男');
INSERT INTO student (id, name, age, gender) VALUES (4, '李云', '1990-12-06', '男');
INSERT INTO student (id, name, age, gender) VALUES (5, '周梅', '1991-12-01', '女');
INSERT INTO student (id, name, age, gender) VALUES (6, '吴兰', '1992-01-01', '女');
INSERT INTO student (id, name, age, gender) VALUES (7, '郑竹', '1989-01-01', '女');
INSERT INTO student (id, name, age, gender) VALUES (9, '张三', '2017-12-20', '女');
INSERT INTO student (id, name, age, gender) VALUES (10, '李四', '2017-12-25', '女');
INSERT INTO student (id, name, age, gender) VALUES (11, '李四', '2012-06-06', '女');
INSERT INTO student (id, name, age, gender) VALUES (12, '赵六', '2013-06-13', '女');
INSERT INTO student (id, name, age, gender) VALUES (13, '孙七', '2014-06-01', '女');
INSERT INTO teacher (id, name) VALUES (1, '张三');
INSERT INTO teacher (id, name) VALUES (2, '李四');
INSERT INTO teacher (id, name) VALUES (3, '王五');
INSERT INTO course (id, name, teacher_id) VALUES (1, '语文', 2);
INSERT INTO course (id, name, teacher_id) VALUES (2, '数学', 1);
INSERT INTO course (id, name, teacher_id) VALUES (3, '英语', 3);
INSERT INTO score (student_id, course_id, score) VALUES (1, 1, 80);
INSERT INTO score (student_id, course_id, score) VALUES (1, 2, 90);
INSERT INTO score (student_id, course_id, score) VALUES (1, 3, 99);
INSERT INTO score (student_id, course_id, score) VALUES (2, 1, 70);
INSERT INTO score (student_id, course_id, score) VALUES (2, 2, 60);
INSERT INTO score (student_id, course_id, score) VALUES (2, 3, 80);
INSERT INTO score (student_id, course_id, score) VALUES (3, 1, 80);
INSERT INTO score (student_id, course_id, score) VALUES (3, 2, 80);
INSERT INTO score (student_id, course_id, score) VALUES (3, 3, 80);
INSERT INTO score (student_id, course_id, score) VALUES (4, 1, 50);
INSERT INTO score (student_id, course_id, score) VALUES (4, 2, 30);
INSERT INTO score (student_id, course_id, score) VALUES (4, 3, 20);
INSERT INTO score (student_id, course_id, score) VALUES (5, 1, 76);
INSERT INTO score (student_id, course_id, score) VALUES (5, 2, 87);
INSERT INTO score (student_id, course_id, score) VALUES (6, 1, 31);
INSERT INTO score (student_id, course_id, score) VALUES (6, 3, 34);
INSERT INTO score (student_id, course_id, score) VALUES (7, 2, 89);
INSERT INTO score (student_id, course_id, score) VALUES (7, 3, 98);
```

答案

查询同名学生的名字并统计个数。

```SQL
SELECT name, count(*)
FROM student
GROUP BY name
HAVING count(*) > 1;
```

查询全部同名学生的信息。

```SQL
SELECT *
FROM student
WHERE name IN (
    SELECT name
    FROM student
    GROUP BY name
    HAVING count(*) > 1
);
```