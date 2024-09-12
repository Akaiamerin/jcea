题目

对 `Collection` 接口的子类 `ArrayList` 进行代理，以前的 `remove` 方法是删除集合中第一次出现的元素。代理后，要求在调用 `remove` 方法能够删除集合中所有匹配的元素。

答案

[Demo1.java](./src/day6/demo1/Demo1.java)

<br>

题目

执行下面的 SQL 脚本，完成相应的查询练习。

```SQL
CREATE TABLE dept (
    id INT NOT NULL,
    name VARCHAR(20),
    loc VARCHAR(20),
    PRIMARY KEY (id)
);
CREATE TABLE job (
    id INT NOT NULL,
    name VARCHAR(20),
    description VARCHAR(20),
    PRIMARY KEY (id)
);
CREATE TABLE emp (
    id INT NOT NULL,
    name VARCHAR(20),
    job_id INT,
    mgr_id INT,
    join_date DATE,
    salary DECIMAL(7, 2),
    bonus DECIMAL(7, 2),
    dept_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (job_id) REFERENCES job (id),
    FOREIGN KEY (dept_id) REFERENCES dept (id)
);
CREATE TABLE salary_grade (
    grade INT NOT NULL,
    low_salary INT,
    high_salary INT,
    PRIMARY KEY (grade)
);
INSERT INTO dept (id, name, loc) VALUES (10, '教研部', '北京');
INSERT INTO dept (id, name, loc) VALUES (20, '学工部', '上海');
INSERT INTO dept (id, name, loc) VALUES (30, '销售部', '广州');
INSERT INTO dept (id, name, loc) VALUES (40, '财务部', '深圳');
INSERT INTO job (id, name, description) VALUES (1, '董事长', '管理整个公司');
INSERT INTO job (id, name, description) VALUES (2, '经理', '管理部门员工');
INSERT INTO job (id, name, description) VALUES (3, '销售员', '向客人推销产品');
INSERT INTO job (id, name, description) VALUES (4, '文员', '使用办公软件');
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1001, '孙悟空', 4, 1004, '2000-12-17', '8000.00', NULL, 20);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1002, '卢俊义', 3, 1006, '2001-02-20', '16000.00', '3000.00', 30);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1003, '林冲', 3, 1006, '2001-02-22', '12500.00', '5000.00', 30);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1004, '唐僧', 2, 1009, '2001-04-02', '29750.00', NULL, 20);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1005, '李逵', 4, 1006, '2001-09-28', '12500.00', '14000.00', 30);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1006, '宋江', 2, 1009, '2001-05-01', '28500.00', NULL, 30);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1007, '刘备', 2, 1009, '2001-09-01', '24500.00', NULL, 10);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1008, '猪八戒', 4, 1004, '2007-04-19', '30000.00', NULL, 20);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1009, '罗贯中', 1, NULL, '2001-11-17', '50000.00', NULL, 10);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1010, '吴用', 3, 1006, '2001-09-08', '15000.00', '0.00', 30);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1011, '沙僧', 4, 1004, '2007-05-23', '11000.00', NULL, 20);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1012, '李逵', 4, 1006, '2001-12-03', '9500.00', NULL, 30);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1013, '小白龙', 4, 1004, '2001-12-03', '30000.00', NULL, 20);
INSERT INTO emp (id, name, job_id, mgr_id, join_date, salary, bonus, dept_id) VALUES (1014, '关羽', 4, 1007, '2002-01-23', '13000.00', NULL, 10);
INSERT INTO salary_grade (grade, low_salary, high_salary) VALUES (1, 7000, 12000);
INSERT INTO salary_grade (grade, low_salary, high_salary) VALUES (2, 12001, 14000);
INSERT INTO salary_grade (grade, low_salary, high_salary) VALUES (3, 14001, 20000);
INSERT INTO salary_grade (grade, low_salary, high_salary) VALUES (4, 20001, 30000);
INSERT INTO salary_grade (grade, low_salary, high_salary) VALUES (5, 30001, 99990);
```

答案

查询职务为经经理的员工姓名、工资、职务名称、职务描述、部门名称、部门位置、工资等级。

```SQL
SELECT emp.name, emp.salary, job.name, job.description, dept.name, dept.loc, salary_grade.grade
FROM emp
INNER JOIN job
ON emp.job_id = job.id
INNER JOIN dept
ON emp.dept_id = dept.id
INNER JOIN salary_grade
ON emp.salary BETWEEN salary_grade.low_salary AND salary_grade.high_salary
WHERE job.name = '经理';
```

查询每个部门的部门编号、部门名称、部门位置、部门人数。

```SQL
SELECT dept.id, dept.name, dept.loc, IFNULL(temp.total, 0) AS '部门人数'
FROM dept
LEFT JOIN (
    SELECT dept_id, count(*) AS total
    FROM emp
    GROUP BY dept_id
) AS temp
ON dept.id = temp.dept_id;
```