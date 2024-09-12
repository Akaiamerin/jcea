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

查询课程名称为数学，分数低于 60 的学生姓名、分数。

```SQL
SELECT student.name, score.score
FROM student
LEFT JOIN score
ON student.id = score.student_id
LEFT JOIN course
ON score.course_id = course.id
WHERE course.name = '数学' AND score.score < 60;
```

查询任何一门课程成绩在 70 分以上的学生姓名、课程名称、分数。

```SQL
SELECT student.name, course.name, score.score
FROM student
LEFT JOIN score
ON student.id = score.student_id
LEFT JOIN course
ON score.course_id = course.id
WHERE score.score > 70;
```