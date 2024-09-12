题目

执行下面的 SQL 脚本，完成相应的查询练习。

```SQL
CREATE TABLE dept (
    no INT NOT NULL,
    name VARCHAR(20),
    location VARCHAR(20),
    PRIMARY KEY (no)
);
CREATE TABLE emp (
    no INT NOT NULL,
    name VARCHAR(20),
    job VARCHAR(20),
    mgr_no INT,
    hire_date DATE,
    salary DOUBLE,
    comm DOUBLE,
    dept_no INT,
    PRIMARY KEY (no),
    FOREIGN KEY (dept_no) REFERENCES dept (no)
);
INSERT INTO dept (no, name, location) VALUES (10, '财务部', '北京');
INSERT INTO dept (no, name, location) VALUES (20, '研发部', '上海');
INSERT INTO dept (no, name, location) VALUES (30, '销售部', '广州');
INSERT INTO dept (no, name, location) VALUES (40, '行政部', '深圳');
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7369, '刘一', '职员', 7902, '1980-12-17', 800, NULL, 20);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7499, '陈二', '推销员', 7698, '1981-02-20', 1600, 300, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7521, '张三', '推销员', 7698, '1981-02-22', 1250, 500, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7566, '李四', '经理', 7839, '1981-04-02',2975, NULL, 20);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7654, '王五', '推销员', 7698, '1981-09-28', 1250, 1400, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7698, '赵六', '经理', 7839, '1981-05-01', 2850, NULL, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7782, '孙七', '经理', 7839, '1981-06-09', 2450, NULL, 10);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7788, '周八', '分析师', 7566, '1987-06-13', 3000, NULL, 20);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7839, '吴九', '总裁', NULL, '1981-11-17', 5000, NULL, 10);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7844, '郑十', '推销员', 7698, '1981-09-08', 1500, 0, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7876, '郭靖', '职员', 7788, '1987-06-13', 1100, NULL, 20);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7900, '令狐冲', '职员', 7698, '1981-12-03', 950, NULL, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7902, '张无忌', '分析师', 7566, '1981-12-03', 3000, NULL, 20);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7934, '杨过', '职员', 7782, '1983-01-23', 1300, NULL, 10);
```

答案

查询至少有一个员工的所有部门。

```SQL
SELECT dept.name, COUNT(emp.dept_no)
FROM dept
LEFT JOIN emp
ON dept.no = emp.dept_no
GROUP BY dept.no
HAVING COUNT(emp.dept_no) >= 1;
```

查询工资比刘一高的所有员工信息。

```SQL
SELECT *
FROM emp
WHERE salary > (
    SELECT salary
    FROM emp
    WHERE name = '刘一'
);
```

查询所有员工的姓名及其直接上级的姓名。

```SQL
SELECT e1.name, e2.name
FROM emp AS e1, emp AS e2
WHERE e1.mgr_no = e2.no;
```

查询受雇日期早于其直接上级的所有员工姓名。

```SQL
SELECT e1.name
FROM emp AS e1, emp AS e2
WHERE e1.mgr_no = e2.no AND e1.hire_date < e2.hire_date;
```

查询部门名称和这些部门的员工信息，包括没有员工的部门。

```SQL
SELECT dept.name, emp.*
FROM dept
LEFT JOIN emp
ON dept.no = emp.dept_no;
```

查询所有职务为职员的姓名及其部门名称。

```SQL
SELECT emp.name, dept.name
FROM emp, dept
WHERE emp.dept_no = dept.no AND emp.job = '职员';
```

查询最低工资大于 1500 的各种工作。

```SQL
SELECT DISTINCT job
FROM emp
WHERE salary > 1500;
```

查询销售部工作的员工的姓名（假设不知道销售部的部门编号）。

```SQL
SELECT emp.name
FROM emp, dept
WHERE emp.dept_no = dept.no AND dept.name = '销售部';
```

查询工资高于公司平均工资的所有员工信息。

```SQL
SELECT *
FROM emp
WHERE salary > (
    SELECT AVG(salary)
    FROM emp
);
```

查询与周八从事相同工作的所有员工信息。

```SQL
SELECT *
FROM emp 
WHERE job = (
    SELECT job
    FROM emp
    WHERE name = '周八'
);
```

查询工资高于在部门 30 工作的所有员工的工资的员工姓名和工资。

```SQL
SELECT name, salary
FROM emp
WHERE salary > ALL(
    SELECT salary
    FROM emp
    WHERE dept_no = 30
);
```

查询在每个部门工作的员工数量、平均工资。

```SQL
SELECT dept.no, COUNT(emp.no), AVG(salary)
FROM dept
LEFT JOIN emp
ON dept.no = emp.dept_no
GROUP BY dept.no;
```

查询所有员工的姓名、部门名称、工资。

```SQL
SELECT emp.name, dept.name, emp.salary
FROM emp, dept
WHERE emp.dept_no = dept.no;
```

查询所有部门的信息和部门人数。

```SQL
SELECT dept.*, IFNULL(emp_count, 0)
FROM dept
LEFT JOIN (
    SELECT dept_no, COUNT(no) AS emp_count
    FROM emp
    GROUP BY dept_no
) AS temp
ON dept.no = temp.dept_no;
```

查询各种工作的最低工资。

```SQL
SELECT job, MIN(salary)
FROM emp
GROUP BY job;
```

查询各个部门的经理的最低工资。

```SQL
SELECT dept_no, MIN(salary)
FROM emp
WHERE job = '经理'
GROUP BY dept_no;
```

查询所有员工的年薪，年薪按从低到高排序。 

```SQL
SELECT name, 12 * (salary + IFNULL(comm, 0)) AS year_salary
FROM emp
ORDER BY year_salary ASC;
```

查询所有的工作种类（无重复）。

```SQL
SELECT DISTINCT job
FROM emp;
```

查询所有奖金字段不为空的所有员工信息。

```SQL
SELECT *
FROM emp
WHERE comm IS NOT NULL;
```

查询名字中有“张”，并且工资在 1000 以上（不包括1000）的所有员工信息。

```SQL
SELECT *
FROM emp
WHERE name LIKE '%张%' AND salary > 1000;
```

将所有员工按照工资升序排序，工资相同的按照入职时间降序排序。

```SQL
SELECT *
FROM emp
ORDER BY salary ASC, hire_date DESC;
```

将所有员工按照名字首字母升序排序，首字母相同的按照工资降序排序。

```SQL
SELECT *
FROM emp
ORDER BY CONVERT(SUBSTRING(name, 1, 1) USING gbk) ASC, salary desc;
```

查询最早工作的员工的姓名、入职时间、工资。

```SQL
SELECT name, hire_date, salary
FROM emp
WHERE hire_date = (
    SELECT MIN(hire_date)
    FROM emp
);
```

查询工资最高的员工的职位。

```SQL
SELECT job
FROM emp
WHERE salary = (
    SELECT MAX(salary)
    FROM emp
);
```

查询所有部门的最高工资和最低工资，部门编号为 40 的不显示。

```SQL
SELECT dept.name, max_salary, min_salary
FROM dept
LEFT JOIN (
    SELECT dept_no, max(salary) AS max_salary, min(salary) AS min_salary
    FROM emp
    GROUP BY dept_no
) AS temp
ON dept.no = temp.dept_no
WHERE dept.no != 40;
```

删除 10 号部门中工资最高的员工。

```SQL
DELETE FROM emp
WHERE no IN (
    SELECT no
    FROM (
        SELECT no
        FROM emp
        WHERE dept_no = 10 AND salary >= ALL(
            SELECT salary
            FROM emp
            WHERE dept_no = 10
        )
    ) AS temp
);
```

将工资最高的员工的工资降低 30%。

```SQL
UPDATE emp
SET salary = 0.7 * salary
WHERE no IN (
    SELECT no
    FROM (
        SELECT no
        FROM emp
        WHERE salary >= ALL(
            SELECT salary
            FROM emp
        )
    ) temp
);
```