CREATE DATABASE rest_db;

use rest_db;

CREATE TABLE category(
category_id INT PRIMARY KEY AUTO_INCREMENT, 
category_name VARCHAR(100)
);

CREATE TABLE advertisment(
advertisment_id INT PRIMARY KEY AUTO_INCREMENT,
advertisment_title VARCHAR(100),
advertisment_description VARCHAR(100),
category_id INT, 
FOREIGN KEY (category_id) REFERENCES category(category_id)
);

INSERT INTO category VALUES(1,'A');
INSERT INTO category VALUES(2,'B');
INSERT INTO category VALUES(3,'C');
INSERT INTO category VALUES(4,'D');

SELECT category_id,category_name FROM category;

INSERT INTO advertisment VALUES(1,'A1','desA1',1);
INSERT INTO advertisment VALUES(2,'A2','desA2',1);
INSERT INTO advertisment VALUES(3,'A3','desA3',1);
INSERT INTO advertisment VALUES(4,'B1','desB1',2);
INSERT INTO advertisment VALUES(5,'B2','desB2',2);
INSERT INTO advertisment VALUES(6,'C1','desD1',3);

SELECT * FROM ADVERTISMENT;
SELECT * FROM category;
SELECT *FROM advertisment;

