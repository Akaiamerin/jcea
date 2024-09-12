CREATE DATABASE IF NOT EXISTS jdbc;

USE jdbc;

DROP TABLE IF EXISTS cake;

CREATE TABLE cake (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    price Double NOT NULL,
    number INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO cake (id, name, price, number) VALUES (NULL, '缤纷年华', 12.8, 999);
INSERT INTO cake (id, name, price, number) VALUES (NULL, '甜蜜物语', 18.8, 999);
INSERT INTO cake (id, name, price, number) VALUES (NULL, '娜爱丝甜品', 9.9, 999);
INSERT INTO cake (id, name, price, number) VALUES (NULL, '朵莎', 15.8, 999);

TRUNCATE TABLE cake;