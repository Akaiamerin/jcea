题目

介绍一下 DDL、DML、DQL、DCL 分别表示的语句种类。

答案

DDL（Data Definition Language，数据定义语言）：定义数据库对象，数据库、表、字段等。

DML（Data Manipulation Language，数据操作语言）：定义对数据库中表的记录进行操作。

DQL（Data Query Language，数据查询语言）：查询数据库中表的记录。

DCL（Data Control Language，数据控制语言）：定义数据库的访问权限、安全级别、用户。

<br>

题目

使用 root 用户登录数据库，创建数据库并设置编码为 UTF8。

使用 root 用户登录数据库、查询数据库、使用数据库、删除数据库。

答案

创建数据库：


```SQL
CREATE DATABASE <database_name> CHARACTER SET utf8;
```

查询数据库：

```SQL
SHOW DATABASES;
```

使用数据库：

```SQL
use <database_name>;
```

查看当前使用的数据库：

```SQL
SELECT DATABASE();
```

查看数据库的定义的信息：

```SQL
SHOW CREATE database <database_name>;
```

删除数据库：

```SQL
drop database <database_name>;
```

<br>

题目

创建表 `category`。

使用 `INSERT` 命令插入 `category` 数据。

使用 `DELETE` 命令删除 `category` 一条记录。

使用 `UPDATE` 命令修改 `category` 某些记录的字段值。

答案

```SQL
CREATE TABLE category (
    id INT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);
```

```SQL
INSERT INTO category (id, name) VALUES (1, '手机');
INSERT INTO category (id, name) VALUES (2, '平板');
INSERT INTO category (id, name) VALUES (3, '笔记本');
```

```SQL
DELETE FROM category WHERE id = 1;
```

```SQL
UPDATE category SET name = '电脑' WHERE id = 2;
```

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
INSERT INTO product (pid, pname, price, category_id) VALUES (1, '联想', 5000, 1);
INSERT INTO product (pid, pname, price, category_id) VALUES (2, '海尔', 3000, 1);
INSERT INTO product (pid, pname, price, category_id) VALUES (3, '雷神', 5000, 1);
INSERT INTO product (pid, pname, price, category_id) VALUES (4, 'JACK JONES', 800, 2);
INSERT INTO product (pid, pname, price, category_id) VALUES (5, '真维斯', 200, 2);
INSERT INTO product (pid, pname, price, category_id) VALUES (6, '花花公子', 440, 2);
INSERT INTO product (pid, pname, price, category_id) VALUES (7, '劲霸', 2000, 2);
INSERT INTO product (pid, pname, price, category_id) VALUES (8, '香奈儿', 800, 'c003');
INSERT INTO product (pid, pname, price, category_id) VALUES (9, '相宜本草', 200, 3);
INSERT INTO product (pid, pname, price, category_id) VALUES (10, '面霸', 5, 3);
INSERT INTO product (pid, pname, price, category_id) VALUES (11, '好想你枣', 56, 4);
INSERT INTO product (pid, pname, price, category_id) VALUES (12, '香飘飘奶茶', 1, 5);
INSERT INTO product (pid, pname, price, category_id) VALUES (13, '果9', 1, NULL);
```

答案

查询商品名称为“花花公子”的所有商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE pname = '花花公子';
```

查询价格为 800 的所有商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE price = 800;
```

查询价格不为 800 的所有商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE price != 800;
```

查询价格大于 60 的所有商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE price > 60;
```

查询价格在 200 到 1000 之间的所有商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE price >= 200 AND price <= 1000;
```

查询价格是 200 或 800 的所有商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE price = 200 OR price = 800;
```

查询含有“霸”字的所有商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE pname LIKE '%霸%';
```

查询以“香”开头的所有商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE pname LIKE '香%';
```

查询第二个字为“想”的所有商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE pname LIKE '_想%';
```

查询没有分类的商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE category_id IS NULL;
```

查询有分类的商品信息。

```SQL
SELECT pid, pname, price, category_id
FROM product
WHERE category_id IS NOT NULL;
```