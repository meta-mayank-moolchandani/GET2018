create database user_details;

use user_details;

CREATE TABLE user_info(
user_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(100),
last_name VARCHAR(100),
age INT,
dob DATE,
mobile_number VARCHAR(100),
email VARCHAR(100) UNIQUE,
password VARCHAR(100),
org_name VARCHAR(100),
image_url VARCHAR(100) DEFAULT './images/dummy.jpg'
);

drop database user_details;