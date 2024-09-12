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
CREATE TABLE salary_grade (
    grade INT NOT NULL,
    low_salary DOUBLE,
    high_salary DOUBLE,
    PRIMARY KEY (grade)
);
INSERT INTO dept (no, name, location) VALUES (10, '财务部', '北京');
INSERT INTO dept (no, name, location) VALUES (20, '市场部', '上海');
INSERT INTO dept (no, name, location) VALUES (30, '销售部', '广州');
INSERT INTO dept (no, name, location) VALUES (40, '运营部', '深圳');
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7369, 'smith', '保洁工作', 7902, '1980-12-17', 800, NULL, 20);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7499, 'allen', '销售工作', 7698, '1981-02-20', 1600, 300, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7521, 'ward', '销售工作', 7698, '1981-02-22', 1250, 500, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7566, 'jones', '管理工作', 7839, '1981-04-02', 2975, NULL, 20);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7654, 'martin', '销售工作', 7698, '1981-09-28', 1250, 1400, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7698, 'blake', '管理工作', 7839, '1981-05-01', 2850, NULL, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7782, 'clark', '管理工作', 7839, '1981-06-09', 2450, NULL, 10);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7788, 'scott', '策划工作', 7566, '1987-07-03', 3000, NULL, 20);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7839, 'king', '大BOSS', NULL, '1981-11-17', 5000, NULL, 10);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7844, 'turner', '销售工作', 7698, '1981-09-08', 1500, 0, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7876, 'adams', '保洁工作', 7788, '1987-07-13', 1100, NULL, 20);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7900, 'james', '保洁工作', 7698, '1981-12-03', 950, NULL, 30);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7902, 'ford', '策划工作', 7566, '1981-12-03', 3000, NULL, 20);
INSERT INTO emp (no, name, job, mgr_no, hire_date, salary, comm, dept_no) VALUES (7934, 'miller', '保洁工作', 7782, '1981-01-23', 1300, NULL, 10);
INSERT INTO salary_grade (grade, low_salary, high_salary) VALUES (1, 700, 1200);
INSERT INTO salary_grade (grade, low_salary, high_salary) VALUES (2, 1201, 1400);
INSERT INTO salary_grade (grade, low_salary, high_salary) VALUES (3, 1401, 2000);
INSERT INTO salary_grade (grade, low_salary, high_salary) VALUES (4, 2001, 3000);
INSERT INTO salary_grade (grade, low_salary, high_salary) VALUES (5, 3001, 9999);
```

答案

查询拥有员工的部门名、部门号。

```SQL
SELECT DISTINCT dept.name, dept.no
FROM emp, dept
WHERE emp.dept_no = dept.no;
```

查询工资水平高于 smith 的员工信息。

```SQL
SELECT *
FROM emp
WHERE salary > (
    SELECT salary
    FROM emp WHERE
    name = 'smith'
);
```

查询员工和所属经理的姓名。

```SQL
SELECT e1.name, e2.name
FROM emp AS e1, emp AS e2
WHERE e1.mgr_no = e2.no;
```

查询员工的雇佣日期早于其经理的雇佣日期的员工及其经理的姓名。

```SQL
SELECT e1.name, e2.name
FROM emp AS e1, emp AS e2
WHERE e1.mgr_no = e2.no AND e1.hire_date < e2.hire_date;
```

查询员工姓名及其所在的部门名称。

```SQL
SELECT emp.name, dept.name
FROM emp, dept
WHERE emp.dept_no = dept.no;
```

查询从事"保洁工作"的员工姓名及其所在部门名称。

```SQL
SELECT emp.name, dept.name
FROM emp, dept
WHERE emp.dept_no = dept.no AND emp.job = '保洁工作';
```

查询部门号及其本部门的最低工资。

```SQL
SELECT dept.no, min(emp.salary)
FROM emp, dept
WHERE emp.dept_no = dept.no
GROUP BY emp.dept_no;
```

查询"销售部"所有员工的姓名。

```SQL
SELECT emp.name
FROM emp, dept
WHERE emp.dept_no = dept.no AND dept.name = '销售部';
```

查询工资水平高于于平均工资的员工信息。

```SQL
SELECT *
FROM emp
WHERE salary > (
    SELECT AVG(salary)
    FROM emp
);
```

查询和 scott 从事相同工作的员工信息。

```SQL
SELECT *
FROM emp
WHERE job = (
    SELECT job
    FROM emp
    WHERE name = 'scott'
);
```

查询和 30 号部门员工工资相同的员工姓名和工资。

```SQL
SELECT name, salary
FROM emp
WHERE salary IN (
    SELECT salary
    FROM emp
    WHERE dept_no = 30
);
```

查询工资高于 30 号部门所有员工工资的员工信息。

```SQL
SELECT *
FROM emp
WHERE salary > (
    SELECT MAX(salary)
    FROM emp
    WHERE dept_no = 30
);
```

查询部门号、部门名、部门所在位置及其每个部门的员工总数。

```SQL
SELECT dept.no, dept.name, dept.location, COUNT(*)
FROM dept, emp
WHERE dept.no = emp.dept_no
GROUP BY dept.no;
```

查询员工的姓名、所在部门名、工资。

```SQL
SELECT emp.name, dept.name, emp.salary
FROM emp, dept
WHERE dept.no = emp.dept_no;
```

查询员工的详细信息（包括部门名）。

```SQL
SELECT emp.*, dept.name
FROM emp
LEFT JOIN dept
ON dept.no = emp.dept_no;
```

查询员工工作和从事此工作的最低工资。

```SQL
SELECT emp.job, MIN(emp.salary)
FROM emp
GROUP BY emp.job;
```

计算出员工的年薪，并且按照年薪升序排序。

```SQL
SELECT 12 * salary
FROM emp
ORDER BY 12 * salary;
```

查询工资处于第四级别的员工的姓名。

```SQL
SELECT emp.name
FROM emp, salary_grade
WHERE salary_grade.grade = 4 AND emp.salary >= salary_grade.low_salary AND emp.salary <= salary_grade.high_salary;
```

查询工资为二等级的员工姓名、部门所在地、以及二等级的最低工资和最高工资。

```SQL
SELECT emp.name, dept.location, salary_grade.low_salary, salary_grade.high_salary
FROM emp, dept, salary_grade
WHERE emp.dept_no = dept.no AND salary_grade.grade = 2 AND emp.salary >= salary_grade.low_salary AND emp.salary <= salary_grade.high_salary;
```

查询工资等级高于 smith 的员工信息。

```SQL
SELECT emp.*
FROM emp, salary_grade
WHERE salary_grade.grade > (
    SELECT salary_grade.grade
    FROM emp, salary_grade
    WHERE emp.name = 'smith' AND emp.salary >= salary_grade.low_salary AND emp.salary <= salary_grade.high_salary
) AND emp.salary >= salary_grade.low_salary AND emp.salary <= salary_grade.high_salary;
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


查询没学过关羽老师课的同学的学号、姓名。

```SQL
SELECT id, name
FROM student
WHERE id NOT IN (
    SELECT student_id
    FROM student_course
    WHERE course_id IN (
        SELECT id
        FROM course
        WHERE teacher_id = (
            SELECT id
            FROM teacher
            WHERE name = '关羽'
        )
    )
);
```

查询没有学过三门课以上的同学的学号、姓名。

```SQL
SELECT id, name
FROM student,
(
    SELECT student_id, COUNT(course_id)
    FROM student_course
    GROUP BY student_id
    HAVING COUNT(course_id) <= 3
) AS temp
WHERE student.id = temp.student_id;
```

<br>

题目

自来水公司收费系统。

基础信息管理：业主类型设置；价格设置；区域设置；收费员设置；地址设置。

业主信息管理：业主信息维护；业主信息查询。

收费管理：抄表登记；收费登记；收费记录查询；欠费用户清单。

统计分析：收费日报单；收费月报表。

设计表结构：

业主类型表（`owner_type`）

| 字段名 | 类型 | 是否必填 | 说明 |
| - | - | - | - |
| `id` | `INT(11)` | 是 | 主键 |
| `name` | `VARCHAR(20)` | 是 | 类型名称 |

价格表（`price`）

| 字段名 | 类型 | 是否必填 | 说明 |
| - | - | - | - |
| `id` | `INT(11)` | 是 | 主键 |
| `price` | `DECIMAL(10, 2)` | 是 | 价格 |
| `owner_type_id` | `INT(11)` | 是 | 业主类型 id |
| `min_num` | `INT(11)` | 否 | 区间最小值 |
| `max_num` | `INT(11)` | 否 | 区间最大值 |

区域表（`area`）

| 字段名 | 类型 | 是否必填 | 说明 |
| - | - | - | - |
| `id` | `INT(11)` | 是 | 主键 |
| `name` | `VARCHAR(20)` | 是 | 区域名称 |

操作员表（`operator`）

| 字段名 | 类型 | 是否必填 | 说明 |
| - | - | - | - |
| `id` | `INT(11)` | 是 | 主键 |
| `name` | `VARCHAR(20)` | 是 | 操作员名称 |

地址表（`address`）

| 字段名 | 类型 | 是否必填 | 说明 |
| - | - | - | - |
| `id` | `INT(11)` | 是 | 主键 |
| `name` | `VARCHAR(20)` | 是 | 地址名称 |
| `area_id` | `INT(11)` | 是 | 区域 id |
| `operator_id` | `INT(11)` | 是 | 操作员 id |

业主表（`owner`）

| 字段名 | 类型 | 是否必填 | 说明 |
| - | - | - | - |
| `id` | `INT(11)` | 是 | 主键 |
| `name` | `VARCHAR(20)` | 是 | 业主名称 |
| `address_id` | `INT(11)` | 是 | 地址 id |
| `house_number` | `VARCHAR(20)` | 是 | 门牌号 |
| `watermeter` | `VARCHAR(20)` | 是 | 水表编号 |
| `record_date` | `DATE` | 是 | 登记日期 |
| `owner_type_id` | `INT(11)` | 是 | 业主类型 id |

收费账单表（`account`）

| 字段名 | 类型 | 是否必填 | 说明 |
| - | - | - | - |
| `id` | `INT(11)` | 是 | 主键 |
| `owner_id` | `INT(11)` | 是 | 业主 id |
| `owner_type_id` | `INT(11)` | 是 | 业主类型 id |
| `area_id` | `INT(11)` | 是 | 区域 id |
| `year` | `CHAR(4)` | 是 | 账务年份 |
| `month` | `CHAR(2)` | 是 | 账务月份 |
| `prev_num` | `INT(11)` | 是 | 上月累计数 |
| `cur_num` | `INT(11)` | 是 | 本月累计数 |
| `use_num` | `INT(11)` | 是 | 本月用水数 |
| `meter_user_id` | `INT(11)` | 是 | 抄表员 |
| `meterdate` | `DATE` | 是 | 抄表日期 |
| `money` | `DECIMAL(10, 2)` | 是 | 应缴金额 |
| `is_fee` | `CHAR(1)` | 是 | 是否缴费 |
| `fee_date` | `DATE` | 是 | 缴费日期 |
| `fee_user_id` | `INT(11)` | 是 | 收费员 |

答案

创建表结构：

```SQL
CREATE TABLE owner_type (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE price (
    id INT(11) NOT NULL AUTO_INCREMENT,
    price DECIMAL(10, 2) NOT NULL,
    owner_type_id INT(11) NOT NULL,
    min_num INT(11),
    max_num INT(11),
    PRIMARY KEY (id)
);
CREATE TABLE area (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE operator (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE address (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    area_id INT(11) NOT NULL,
    operator_id INT(11) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE owner (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    address_id INT(11) NOT NULL,
    house_number VARCHAR(20) NOT NULL,
    watermeter VARCHAR(20) NOT NULL,
    record_date DATE NOT NULL,
    owner_type_id INT(11) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE account (
    id INT(11) NOT NULL AUTO_INCREMENT,
    owner_id INT(11) NOT NULL,
    owner_type_id INT(11) NOT NULL,
    area_id INT(11) NOT NULL,
    year CHAR(4) NOT NULL,
    month CHAR(2) NOT NULL,
    prev_num INT(11) NOT NULL,
    cur_num INT(11) NOT NULL,
    use_num INT(11) NOT NULL,
    meter_user_id INT(11) NOT NULL,
    meter_date DATE NOT NULL,
    money DECIMAL(10, 2) NOT NULL,
    is_fee CHAR(1) NOT NULL,
    fee_date DATE NOT NULL,
    fee_user_id INT(11) NOT NULL,
    PRIMARY KEY (id)
);
```

导入数据：

```SQL
INSERT INTO owner_type (id, name) VALUES (1, '居民');
INSERT INTO owner_type (id,name) VALUES (2, '行政事业单位');
INSERT INTO owner_type (id, name) VALUES (3, '商业');
INSERT INTO price (id, price, owner_type_id, min_num, max_num) VALUES (1, 2.45, 1, 0, 5);
INSERT INTO price (id, price, owner_type_id, min_num, max_num) VALUES (2, 3.45, 1, 5, 10);
INSERT INTO price (id, price, owner_type_id, min_num, max_num) VALUES (3, 4.45, 1, 10, NULL);
INSERT INTO price (id, price, owner_type_id, min_num, max_num) VALUES (4, 3.87, 2, 0, 5);
INSERT INTO price (id, price, owner_type_id, min_num, max_num) VALUES (5, 4.87, 2, 5, 10);
INSERT INTO price (id, price, owner_type_id, min_num, max_num) VALUES (6, 5.87, 2, 10, NULL);
INSERT INTO price (id, price, owner_type_id, min_num, max_num) VALUES (7, 4.36, 3, 0, 5);
INSERT INTO price (id, price, owner_type_id, min_num, max_num) VALUES (8, 5.36, 3, 5, 10);
INSERT INTO price (id, price, owner_type_id, min_num, max_num) VALUES (9, 6.36, 3, 10, NULL);
INSERT INTO area (id, name) VALUES (1, '海淀');
INSERT INTO area (id, name) VALUES (2, '昌平');
INSERT INTO area (id, name) VALUES (3, '西城');
INSERT INTO area (id, name) VALUES (4, '东城');
INSERT INTO area (id, name) VALUES (5, '朝阳');
INSERT INTO area (id, name) VALUES (6, '玄武');
INSERT INTO operator (id, name) VALUES (1, '马小云');
INSERT INTO operator (id, name) VALUES (2, '李翠花');
INSERT INTO address (id, name, area_id, operator_id) VALUES (1, '明兴花园', 1, 1);
INSERT INTO address (id, name, area_id, operator_id) VALUES (2, '鑫源秋墅', 1, 1);
INSERT INTO address (id, name, area_id, operator_id) VALUES (3, '华龙苑南里小区',2 , 2);
INSERT INTO address (id, name, area_id, operator_id) VALUES (4, '河畔花园', 2, 2);
INSERT INTO address (id, name, area_id, operator_id) VALUES (5, '霍营', 2, 2);
INSERT INTO address (id, name, area_id, operator_id) VALUES (6, '回龙观东大街', 3, 2);
INSERT INTO address (id, name, area_id, operator_id) VALUES (7, '西二旗', 3, 2);
INSERT INTO owner (id, name, address_id, house_number, watermeter, record_date, owner_type_id) VALUES (1, '范冰', 1, '1-1', 30406, DATE_FORMAT('2015-04-12', '%Y-%m-%d'), 1);
INSERT INTO owner (id, name, address_id, house_number, watermeter, record_date, owner_type_id) VALUES (2, '王强', 1, '1-2', 30407, DATE_FORMAT('2015-02-14', '%Y-%m-%d'), 1);
INSERT INTO owner (id, name, address_id, house_number, watermeter, record_date, owner_type_id) VALUES (3, '马腾', 1, '1-3', 30408, DATE_FORMAT('2015-03-18', '%Y-%m-%d'), 1);
INSERT INTO owner (id, name, address_id, house_number, watermeter, record_date, owner_type_id) VALUES (4, '林小玲', 2, '2-4', 30409, DATE_FORMAT('2015-06-15', '%Y-%m-%d'), 1);
INSERT INTO owner (id, name, address_id, house_number, watermeter, record_date, owner_type_id) VALUES (5, '刘华', 2, '2-5', 30410, DATE_FORMAT('2013-09-11', '%Y-%m-%d'), 1);
INSERT INTO owner (id, name, address_id, house_number, watermeter, record_date, owner_type_id) VALUES (6, '刘东', 2, '2-2', 30411, DATE_FORMAT('2014-09-11', '%Y-%m-%d'), 1);
INSERT INTO owner (id, name, address_id, house_number, watermeter, record_date, owner_type_id) VALUES (7, '周健', 3, '2-5', 30433, DATE_FORMAT('2016-09-11', '%Y-%m-%d'), 1);
INSERT INTO owner (id, name, address_id, house_number, watermeter, record_date, owner_type_id) VALUES (8, '张哲', 4, '2-2', 30455, DATE_FORMAT('2016-09-11', '%Y-%m-%d'), 1);
INSERT INTO owner (id, name, address_id, house_number, watermeter, record_date, owner_type_id) VALUES (9, '昌平区中西医结合医院', 5, '2-2', '30422', DATE_FORMAT('2016-10-11', '%Y-%m-%d'), 2);
INSERT INTO owner (id, name, address_id, house_number, watermeter, record_date, owner_type_id) VALUES (10, '美廉美超市', 5, '4-2', '30423', DATE_FORMAT('2016-10-12', '%Y-%m-%d'), 3);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (1, 1, 1, 1, '2012', '01', 30203, 50123, 0, 1, SYSDATE(), 34.51, '1', DATE_FORMAT('2012-02-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (2, 1, 1, 1, '2012', '02', 50123, 60303, 0, 1, SYSDATE(), 23.43, '1', DATE_FORMAT('2012-03-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (3, 1, 1, 1, '2012', '03', 60303, 74111, 0, 1, SYSDATE(), 45.34, '1', DATE_FORMAT('2012-04-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (4, 1, 1, 1, '2012', '04', 74111, 77012, 0, 1, SYSDATE(), 52.54, '1', DATE_FORMAT('2012-05-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (5, 1, 1, 1, '2012', '05', 77012, 79031, 0, 1, SYSDATE(), 54.66, '1', DATE_FORMAT('2012-06-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (6, 1, 1, 1, '2012', '06', 79031, 80201, 0, 1, SYSDATE(), 76.45, '1', DATE_FORMAT('2012-07-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (7, 1, 1, 1, '2012', '07', 80201, 88331, 0, 1, SYSDATE(), 65.65, '1', DATE_FORMAT('2012-08-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (8, 1, 1, 1, '2012', '08', 88331, 89123, 0, 1, SYSDATE(), 55.67, '1', DATE_FORMAT('2012-09-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (9, 1, 1, 1, '2012', '09', 89123, 90122, 0, 1, SYSDATE(), 112.54, '1', DATE_FORMAT('2012-10-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (10, 1, 1, 1, '2012', '10', 90122, 93911, 0, 1, SYSDATE(), 76.21, '1', DATE_FORMAT('2012-11-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (11, 1, 1, 1, '2012', '11', 93911, 95012, 0, 1, SYSDATE(), 76.25, '1', DATE_FORMAT('2012-12-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (12, 1, 1, 1, '2012', '12', 95012, 99081, 0, 1, SYSDATE(), 44.51, '1', DATE_FORMAT('2013-01-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (13, 2, 1, 3, '2012', '01', 30334, 50433, 0, 1, SYSDATE(), 34.51, '1', DATE_FORMAT('2013-02-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (14, 2, 1, 3, '2012', '02', 50433, 60765, 0, 1, SYSDATE(), 23.43, '1', DATE_FORMAT('2013-03-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (15, 2, 1, 3, '2012', '03', 60765, 74155, 0, 1, SYSDATE(), 45.34, '1', DATE_FORMAT('2013-04-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (16, 2, 1, 3, '2012', '04', 74155, 77099, 0, 1, SYSDATE(), 52.54, '1', DATE_FORMAT('2013-05-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (17, 2, 1, 3, '2012', '05', 77099, 79076, 0, 1, SYSDATE(), 54.66, '1', DATE_FORMAT('2013-06-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (18, 2, 1, 3, '2012', '06', 79076, 80287, 0, 1, SYSDATE(), 76.45, '1', DATE_FORMAT('2013-07-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (19, 2, 1, 3, '2012', '07', 80287, 88432, 0, 1, SYSDATE(), 65.65, '1', DATE_FORMAT('2013-08-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (20, 2, 1, 3, '2012', '08', 88432, 89765, 0, 1, SYSDATE(), 55.67, '1', DATE_FORMAT('2013-09-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (21, 2, 1, 3, '2012', '09', 89765, 90567, 0, 1, SYSDATE(), 112.54, '1', DATE_FORMAT('2013-10-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (22, 2, 1, 3, '2012', '10', 90567, 93932, 0, 1, SYSDATE(), 76.21, '1', DATE_FORMAT('2013-11-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (23, 2, 1, 3, '2012', '11', 93932, 95076, 0, 1, SYSDATE(), 76.25, '1', DATE_FORMAT('2013-12-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (24, 2, 1, 3, '2012', '12', 95076, 99324, 0, 1, SYSDATE(), 44.51, '1', DATE_FORMAT('2014-01-14', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (25, 100, 1, 3, '2012', '12', 95076, 99324, 0, 1, SYSDATE(), 44.51, '1', DATE_FORMAT('2014-01-01', '%Y-%m-%d'), 2);
INSERT INTO account (id, owner_id, owner_type_id, area_id, year, month, prev_num, cur_num, use_num, meter_user_id, meter_date, money, is_fee, fee_date, fee_user_id) VALUES (26, 101, 1, 3, '2012', '12', 95076, 99323, 0, 1, SYSDATE(), 44.51, '1', DATE_FORMAT('2015-01-01', '%Y-%m-%d'), 2);
```

```SQL
UPDATE account SET use_num = cur_num - prev_num;
UPDATE account SET money = 2.45 * use_num;
```

修改表结构：

为业主表增加两个字段 `remark VARCHAR(255)`、`out_date Date`。

```SQL
ALTER TABLE owner ADD (
   remark VARCHAR(255),
   out_date DATE
);
```

删除业主表中的 `remark` 字段。

```SQL
ALTER TABLE owner DROP remark;
```

修改业主表中的字段 `out_date` 为 `exit_date`。

```SQL
ALTER TABLE owner CHANGE out_date exit_date DATETIME;
```

查询水表编号为 30408 的业主记录。

```SQL
SELECT *
FROM owner
WHERE watermeter = '30408';
```

查询业主名称包含“刘”的业主记录。

```SQL
SELECT *
FROM owner
WHERE name LIKE '%刘%';
```

查询业主名称包含“刘”且门牌号包含 5 的业主记录。

```SQL
SELECT *
FROM owner
WHERE name LIKE '%刘%' AND house_number LIKE '%5%';
```

查询业主名称包含“刘”或门牌号包含 5 的业主记录。

```SQL
SELECT *
FROM owner
WHERE name LIKE '%刘%' OR house_number LIKE '%5%';
```

查询业主名称包含“刘”或门牌号包含 5，并且地址编号为 3 的业主记录。

```SQL
SELECT *
FROM owner
WHERE (name LIKE '%刘%' OR house_number LIKE '%5%') AND (address_id = 3);
```

查询账单记录中用水数（本月实际用水量）大于等于 10000 且小于等于 20000 的记录。

```SQL
SELECT *
FROM account
WHERE use_num BETWEEN 10000 AND 20000;
```

查询价格表中 max_num 为空的记录。

```SQL
SELECT *
FROM price
WHERE max_num IS NULL;
```

查询价格表中 max_num 不为空的记录。

```SQL
SELECT *
FROM price
WHERE max_num IS NOT NULL;
```

查询业主表中的地址 id（不重复显示）。

```SQL
SELECT DISTINCT address_id
FROM owner;
```

对账单表按照使用量（本月实际用水量）进行升序排序。

```SQL
SELECT *
FROM account
ORDER BY use_num;
```

对账单表按照使用量（本月实际用水量）进行降序排序。

```SQL
SELECT *
FROM account
ORDER BY use_num DESC;
```

统计 2012 年所有用户的用水量（实际用水量）总和。

```SQL
SELECT SUM(use_num)
FROM account
WHERE year = '2012';
```

统计 2012 年所有用户的用水量的平均值。

```SQL
SELECT AVG(use_num)
FROM account
WHERE year = '2012';
```

统计 2012 年最高用水量。

```SQL
SELECT MAX(use_num)
FROM account
WHERE year = '2012';
```

统计 2012 年最低用水量。

```SQL
SELECT MIN(use_num)
FROM account
WHERE year = '2012';
```

统计业主类型 id 为 1 的业主数量。

```SQL
SELECT COUNT(*)
FROM owner
WHERE owner_type_id = 1;
```

按区域分组统计水费合计数。

```SQL
SELECT area_id, SUM(money)
FROM account
GROUP BY area_id;
```

查询水费合计大于 169000 的区域及水费合计。

```SQL
SELECT area_id, SUM(money)
FROM account
GROUP BY area_id
HAVING SUM(money) > 169000;
```

查询业主编号、业主名称、业主类型、地址、所属区域、收费员。

```SQL
SELECT owner.id as '业主编号',
owner.name as '业主名称',
owner_type.name as '业主类型',
address.name as '地址',
area.name as '所属区域',
operator.name as '收费员'
FROM owner, owner_type, address, area, operator
WHERE owner.owner_type_id = owner_type.id
AND owner.address_id = address.id
AND address.area_id = area.id
AND address.operator_id = operator.id
```

查询业主的账务记录，显示业主编号、名称、年、月、金额。业主没有对应的账务记录，也要列出业主记录。

```SQL
SELECT owner.id AS '业主编号',
owner.name AS '业主名称' ,
account.year AS '年份',
account.month AS '月份',
account.money AS '金额'
FROM owner
LEFT JOIN account
ON owner.id = account.owner_id;
```

查询业主的账务记录，显示业主编号、名称、年、月、金额。账务没有对应的业主记录，也要列出账务记录。

```SQL
SELECT owner.id AS '业主编号',
owner.name AS '业主名称' ,
account.year AS '年份',
account.month AS '月份',
account.money AS '金额'
FROM owner
RIGHT JOIN account
ON owner.id = account.owner_id;
```

查询 2012 年 1 月用水量大于平均值的账单记录。

```SQL
SELECT *
FROM account
WHERE year = '2012' AND month = '01' and use_num > (
    SELECT AVG(use_num)
    FROM account
    WHERE year = '2012' AND month = '01'
);
```

查询地址含有“花园”的业主的信息。

```SQL
SELECT *
FROM owner
WHERE address_id IN (
    SELECT id
    FROM address
    WHERE name LIKE '%花园%'
);
```

查询 2012 年账单中，使用量大于 2012 年 3 月最大使用量的账单记录。

```SQL
SELECT *
FROM account
WHERE year = '2012' AND use_num > (
    SELECT MAX(use_num)
    FROM account
    WHERE year = '2012' AND month = '03'
);
```

按月份统计 2012 年各个地区的水费。

```SQL
SELECT (
    SELECT name
    FROM area
    WHERE id = area_id
) AS 区域,
SUM(IF(month = '01', money, 0)) AS "1月",
SUM(IF(month = '02', money, 0)) AS "2月",
SUM(IF(month = '03', money, 0)) AS "3月",
SUM(IF(month = '04', money, 0)) AS "4月",
SUM(IF(month = '05', money, 0)) AS "5月",
SUM(IF(month = '06', money, 0)) AS "6月",
SUM(IF(month = '07', money, 0)) AS "7月",
SUM(IF(month = '08', money, 0)) AS "8月",
SUM(IF(month = '09', money, 0)) AS '9月',
SUM(IF(month = '10', money, 0)) AS '10月',
SUM(IF(month = '11', money, 0)) AS '11月',
SUM(IF(month = '12', money, 0)) AS '12月'
FROM account
WHERE year = '2012'
GROUP BY area_id;
```

按季度统计 2012 年各个地区的水费。

```SQL
SELECT (
    SELECT name
    FROM area
    WHERE id = area_id
) AS 区域,
SUM(IF(month >= '01' AND month <= '03', money, 0)) AS "第一季度",
SUM(IF(month >= '04' AND month <= '06', money, 0)) AS "第二季度",
SUM(IF(month >= '07' AND month <= '09', money, 0)) AS "第三季度",
SUM(IF(month >= '10' AND month <= '12', money, 0)) AS "第四季度"
FROM account
WHERE year = '2012'
GROUP BY area_id;
```