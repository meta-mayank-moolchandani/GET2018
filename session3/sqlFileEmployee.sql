CREATE DATABASE employee;

use employee;

CREATE TABLE employee(
emp_id INT PRIMARY KEY AUTO_INCREMENT,
first_name varchar(100),
last_name varchar(100),
email varchar(255) UNIQUE,
age INT
);

INSERT INTO employee(first_name,last_name,email,age) VALUES ('VIJAY', 'DINANATH CHOHAN','abc@abc.com',15);

select * from employee;

