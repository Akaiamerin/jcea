题目

根据给定的 `stu` 表结构，使用 MyBatis 技术，实现以下需求：

| 字段名 | 类型 | 说明 |
| - | - | - |
| `id` | `INT` | id |
| `name` | `VARCHAR(20)` | 姓名 |
| `age` | `INT` | 年龄|
| `gender` | `CHAR(1)` | 性别 |

插入一条学生信息。

获取所有学生信息。

答案

```SQL
CREATE TABLE stu (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    age INT,
    gender CHAR(1),
    PRIMARY KEY (id)
);
```

[Demo1.java](./src/day7/demo1/Demo1.java)

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

查询每门课程的平均成绩，对平均成绩进行降序排列，平均成绩相同时，对课程编号进行升序排列。

```SQL
SELECT score.course_id, TRUNCATE(AVG(score.score), 2) AS average
FROM score, course
WHERE score.course_id = course.id
GROUP BY score.course_id
ORDER BY AVG(score.score) DESC, score.course_id ASC;
```

查询平均成绩大于等于 85 的所有学生的学号、姓名、平均成绩。

```SQL
SELECT student.id, student.name, TRUNCATE(AVG(score.score),2) AS average
FROM student, score
WHERE student.id = score.student_id
GROUP BY student.id, student.name
HAVING AVG(score.score) >= 85;
```