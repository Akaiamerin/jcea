题目

介绍一下常用的聚合函数。

答案

`COUNT` 统计指定列不为 `NULL` 的记录行数。

`SUM` 计算指定列的数值和，如果指定列类型不是数值类型，那么计算结果为 `0`。

`MAX` 计算指定列的最大值，如果指定列是字符串类型，那么按照字符串排序运算。

`MIN` 计算指定列的最小值，如果指定列是字符串类型，那么按照字符串排序运算。

`AVG` 计算指定列的平均值，如果指定列类型不是数值类型，那么计算结果为 `0`。

<br>

题目

执行下面的 SQL 脚本，完成相应的查询练习。

```SQL
CREATE TABLE product (
    pid INT NOT NULL AUTO_INCREMENT,
    pname VARCHAR(20),
    price DECIMAL(10, 2),
    category_id INT,
    PRIMARY KEY (id)
);
INSERT INTO product(pid, pname, price, category_id) VALUES (1, '联想', 5000, 1);
INSERT INTO product(pid, pname, price, category_id) VALUES (2, '海尔', 3000, 1);
INSERT INTO product(pid, pname, price, category_id) VALUES (3, '雷神', 5000, 1);
INSERT INTO product(pid, pname, price, category_id) VALUES (4, 'JACK JONES', 800, 2);
INSERT INTO product(pid, pname, price, category_id) VALUES (5, '真维斯', 200, 2);
INSERT INTO product(pid, pname, price, category_id) VALUES (6, '花花公子', 440, 2);
INSERT INTO product(pid, pname, price, category_id) VALUES (7, '劲霸', 2000, 2);
INSERT INTO product(pid, pname, price, category_id) VALUES (8, '香奈儿', 800, 'c003');
INSERT INTO product(pid, pname, price, category_id) VALUES (9, '相宜本草', 200, 3);
INSERT INTO product(pid, pname, price, category_id) VALUES (10, '面霸', 5, 3);
INSERT INTO product(pid, pname, price, category_id) VALUES (11, '好想你枣', 56, 4);
INSERT INTO product(pid, pname, price, category_id) VALUES (12, '香飘飘奶茶', 1, 5);
INSERT INTO product(pid, pname, price, category_id) VALUES (13, '果9', 1, NULL);
```

答案

查询商品的总条数。

```SQL
SELECT COUNT(*)
FROM product;
```

查询价格大于 200 商品的总条数。

```SQL
SELECT COUNT(*)
FROM product
WHERE price > 200;
```

查询分类为 1 的所有商品的价格总和。

```SQL
SELECT SUM(price)
FROM product
WHERE category_id = 1;
```

查询分类为 2 的所有商品的平均价格。

```SQL
SELECT AVG(price)
FROM product
WHERE category_id = 2;
```

查询商品的最大价格和最小价格。

```SQL
SELECT MAX(price), MIN(price)
FROM product;
```

统计各个分类商品的个数。

```SQL
SELECT category_id, COUNT(*)
FROM product
GROUP BY category_id;
```

统计各个分类商品的个数，并且显示大于 1 的个数。

```SQL
SELECT category_id, COUNT(*)
FROM product
GROUP BY category_id
HAVING COUNT(*) > 1;
```

<br>

题目

执行下面的 SQL 脚本，完成相应的查询练习。

```SQL
CREATE TABLE teacher (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    PRIMARY KEY (id)
);
CREATE TABLE student (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    city VARCHAR(20),
    age INT,
    PRIMARY KEY (id)
);
CREATE TABLE course (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    teacher_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);
CREATE TABLE student_course (
    student_id INT,
    course_id INT,
    score INT,
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);
INSERT INTO teacher (id, name) VALUES (NULL, '关羽');
INSERT INTO teacher (id, name) VALUES (NULL, '张飞');
INSERT INTO teacher (id, name) VALUES (NULL, '赵云');
INSERT INTO student (id, name, city, age) VALUES (NULL, '小王', '北京', 20);
INSERT INTO student (id, name, city, age) VALUES (NULL, '小李', '上海', 18);
INSERT INTO student (id, name, city, age) VALUES (NULL, '小周', '北京', 22);
INSERT INTO student (id, name, city, age) VALUES (NULL, '小刘', '北京', 21);
INSERT INTO student (id, name, city, age) VALUES (NULL, '小张', '上海', 22);
INSERT INTO student (id, name, city, age) VALUES (NULL, '小赵', '北京', 17);
INSERT INTO student (id, name, city, age) VALUES (NULL, '小蒋', '上海', 23);
INSERT INTO student (id, name, city, age) VALUES (NULL, '小韩', '北京', 25);
INSERT INTO student (id, name, city, age) VALUES (NULL, '小魏', '上海', 25);
INSERT INTO student (id, name, city, age) VALUES (NULL, '小明', '北京', 20);
INSERT INTO course (id, name, teacher_id) VALUES (NULL, '语文', 1);
INSERT INTO course (id, name, teacher_id) VALUES (NULL, '数学', 1);
INSERT INTO course (id, name, teacher_id) VALUES (NULL, '生物', 2);
INSERT INTO course (id, name, teacher_id) VALUES (NULL, '化学', 2);
INSERT INTO course (id, name, teacher_id) VALUES (NULL, '物理', 2);
INSERT INTO course (id, name, teacher_id) VALUES (NULL, '英语', 3);
INSERT INTO student_course (student_id, course_id, score) VALUES (1, 1, 80);
INSERT INTO student_course (student_id, course_id, score) VALUES (1, 2, 90);
INSERT INTO student_course (student_id, course_id, score) VALUES (1, 3, 85);
INSERT INTO student_course (student_id, course_id, score) VALUES (1, 4, 78);
INSERT INTO student_course (student_id, course_id, score) VALUES (2, 2, 53);
INSERT INTO student_course (student_id, course_id, score) VALUES (2, 3, 77);
INSERT INTO student_course (student_id, course_id, score) VALUES (2, 5, 80);
INSERT INTO student_course (student_id, course_id, score) VALUES (3, 1, 71);
INSERT INTO student_course (student_id, course_id, score) VALUES (3, 2, 70);
INSERT INTO student_course (student_id, course_id, score) VALUES (3, 4, 80);
INSERT INTO student_course (student_id, course_id, score) VALUES (3, 5, 65);
INSERT INTO student_course (student_id, course_id, score) VALUES (3, 6, 75);
INSERT INTO student_course (student_id, course_id, score) VALUES (4, 2, 90);
INSERT INTO student_course (student_id, course_id, score) VALUES (4, 3, 80);
INSERT INTO student_course (student_id, course_id, score) VALUES (4, 4, 70);
INSERT INTO student_course (student_id, course_id, score) VALUES (4, 6, 95);
INSERT INTO student_course (student_id, course_id, score) VALUES (5, 1, 60);
INSERT INTO student_course (student_id, course_id, score) VALUES (5, 2, 70);
INSERT INTO student_course (student_id, course_id, score) VALUES (5, 5, 80);
INSERT INTO student_course (student_id, course_id, score) VALUES (5, 6, 69);
INSERT INTO student_course (student_id, course_id, score) VALUES (6, 1, 76);
INSERT INTO student_course (student_id, course_id, score) VALUES (6, 2, 88);
INSERT INTO student_course (student_id, course_id, score) VALUES (6, 3, 87);
INSERT INTO student_course (student_id, course_id, score) VALUES (7, 4, 80);
INSERT INTO student_course (student_id, course_id, score) VALUES (8, 2, 71);
INSERT INTO student_course (student_id, course_id, score) VALUES (8, 3, 58);
INSERT INTO student_course (student_id, course_id, score) VALUES (8, 5, 68);
INSERT INTO student_course (student_id, course_id, score) VALUES (9, 2, 88);
INSERT INTO student_course (student_id, course_id, score) VALUES (10, 1, 77);
INSERT INTO student_course (student_id, course_id, score) VALUES (10, 2, 76);
INSERT INTO student_course (student_id, course_id, score) VALUES (10, 3, 80);
INSERT INTO student_course (student_id, course_id, score) VALUES (10, 4, 85);
INSERT INTO student_course (student_id, course_id, score) VALUES (10, 5, 83);
```

答案

查询平均成绩大于 70 分的同学的学号和平均成绩。

```SQL
SELECT student_id, AVG(score)
FROM student_course
GROUP BY student_id
HAVING AVG(score) > 70;
```

查询所有同学的学号、姓名、选课数、总成绩。

```SQL
SELECT student.id, student.name, temp.course_cnt, temp.score_sum 
FROM student,
(
    SELECT student_id,
    count(course_id) AS course_cnt,
    sum(score) AS score_sum
    FROM student_course
    GROUP BY student_id
) AS temp
WHERE student.id = temp.student_id;
```

查询学过赵云老师所教课的同学的学号、姓名。

```SQL
SELECT id, name
FROM student
WHERE id IN (
    SELECT student_id
    FROM student_course
    WHERE course_id IN (
        SELECT course.id
        FROM teacher, course
        WHERE teacher.id = course.teacher_id AND teacher.name = '赵云'
    ) 
);
```

查询各科成绩最高分和最低分（根据课程分组）。

```SQL
SELECT course_id, MAX(score), MIN(score)
FROM student_course
GROUP BY course_id;
```

<br>

题目

执行下面的 SQL 脚本，完成相应的查询练习。

```SQL
CREATE TABLE dept(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    location VARCHAR(20),
    PRIMARY KEY (id),
);
CREATE TABLE emp (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    job VARCHAR(20),
    mgr_id INT,
    hire_date DATE,
    sal INT,
    comm INT,
    dept_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (dept_id) REFERENCES dept(id)
);
INSERT INTO dept (id, name, location) VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept (id, name, location) VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO dept (id, name, location) VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO dept (id, name, location) VALUES (40, 'OPERATIONS', 'BOSTON');
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250, 500, 30);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, NULL, 20);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850, NULL, 30);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7788, 'SCOTT', 'ANALYST', 7566, '1987-06-13', 3000, NULL, 20);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7876, 'ADAMS', 'CLERK', 7788, '1987-06-13', 1100, NULL, 20);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, NULL, 30);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000, NULL, 20);
INSERT INTO emp (id, name, job, mgr_id, hire_date, sal, comm, dept_id) VALUES (7934, 'MILLER', 'CLERK', 7782, '1983-01-23', 1300, NULL, 10);
```

答案

查询至少有 4 个员工的所有部门信息。

```SQL
SELECT *
FROM dept
WHERE id IN (
    SELECT dept_id
    FROM emp
    GROUP BY dept_id
    HAVING COUNT(*) >= 4
);
```

查询工资比“SMITH”高的所有员工信息。

```SQL
SELECT *
FROM emp
WHERE sal > (
    SELECT sal
    FROM emp
    WHERE name = 'SMITH'
);
```

查询所有员工的姓名及其直接上级的姓名。

```SQL
SELECT e1.name, e2.name
FROM emp AS e1, emp AS e2
WHERE e1.mgr_id = e2.id;
```

查询受雇日期早于其直接上级的所有员工姓名。

```SQL
SELECT e1.name
FROM emp AS e1, emp AS e2
WHERE e1.mgr_id = e2.id AND e1.hire_date < e2.hire_date;
```

查询部门名称和这些部门的员工信息，包括没有员工的部门。

```SQL
SELECT *
FROM dept
LEFT JOIN emp
ON dept.id = emp.dept_id;
```

查询所有“CLERK”（办事员）的姓名及其部门名称。

```SQL
SELECT emp.name, dept.name
FROM emp, dept
WHERE emp.dept_id = dept.id AND emp.job = 'CLERK';
```

查询最低工资大于 1500 的工作。

```SQL
SELECT job
FROM emp
GROUP BY job
HAVING MIN(sal) > 1500;
```