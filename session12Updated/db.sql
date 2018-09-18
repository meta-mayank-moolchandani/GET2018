drop database employee_portal;

create database employee_portal;

use employee_portal;


create table employee(
 emp_code VARCHAR(11) PRIMARY KEY NOT NULL,
 first_name VARCHAR(100) NOT NULL,
 last_name VARCHAR(100),
 dob DATE NOT NULL,
 gender VARCHAR(1) NOT NULL,
 primary_contact_number VARCHAR(10),
 secondary_contact_number VARCHAR(10),
 email_id VARCHAR(100) NOT NULL,
 skype_id VARCHAR(100),
 profile_picture VARCHAR(512),
 password VARCHAR(100) DEFAULT "abcd",
 enabled BOOLEAN DEFAULT true
);

CREATE TABLE job_title_master(
 job_id INT AUTO_INCREMENT PRIMARY KEY ,
 job_title VARCHAR(100) NOT NULL
);
 
CREATE TABLE user_role(
 user_role_id INT PRIMARY KEY AUTO_INCREMENT,
 user_name VARCHAR(200) NOT NULL,
 role VARCHAR(50) NOT NULL    
);

CREATE TABLE skill_master(
 skill_id INT PRIMARY KEY AUTO_INCREMENT,
 skill_name VARCHAR(100) NOT NULL
);



CREATE TABLE employee_skill(
 emp_skill_id INT AUTO_INCREMENT PRIMARY KEY,
 emp_code VARCHAR(11) NOT NULL,
 skill_id INT NOT NULL,
 FOREIGN KEY (emp_code)  REFERENCES employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
 FOREIGN KEY (skill_id)  REFERENCES skill_master(skill_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE project(
 project_id BIGINT PRIMARY KEY auto_increment,
 project_name VARCHAR(100),
 project_description VARCHAR(200) NOT NULL,
 start_date DATE NOT NULL,
 end_date DATE
);


CREATE TABLE address(
 address_id INT PRIMARY KEY,
 emp_code VARCHAR(11) NOT NULL,
 add_line_1 VARCHAR(100) NOT NULL,
 add_line_2 VARCHAR(100),
 FOREIGN KEY (emp_code) REFERENCES employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE job_details(
  job_detail_id INT PRIMARY KEY AUTO_INCREMENT ,
  emp_code VARCHAR(11) NOT NULL,
  job_id INT NOT NULL,
  reproting_mgr VARCHAR(11),
  team_lead VARCHAR(11),
  curr_proj_id BIGINT,
  FOREIGN KEY (emp_code) REFERENCES employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (job_id) REFERENCES job_title_master(job_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (reproting_mgr) REFERENCES Employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (team_lead) REFERENCES Employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (curr_proj_id) REFERENCES project(project_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE token(
emp_code VARCHAR(20),
token VARCHAR(100)
);

INSERT INTO token VALUES('dsad','sd');
select * from token;

INSERT INTO `employee_portal`.`employee` (`emp_code`, `first_name`, `last_name`, `dob`, `gender`, `primary_contact_number`, `secondary_contact_number`, `email_id`, `password`, `enabled`) VALUES ('E18/0000', 'dummy', 'dummy', '1997-08-12', 'M', '123', '123', 'a@b.com', 'abcd', true);
INSERT INTO `employee_portal`.`employee` (`emp_code`, `first_name`, `last_name`, `dob`, `gender`, `primary_contact_number`, `secondary_contact_number`, `email_id`, `password`, `enabled`) VALUES ('E18/0001', 'dummy1', 'dummy1', '1997-08-12', 'F', '123', '123', 'a2@bb.com', 'abcd', true);
INSERT INTO `employee_portal`.`employee` (`emp_code`, `first_name`, `last_name`, `dob`, `gender`, `primary_contact_number`, `secondary_contact_number`, `email_id`, `password`, `enabled`) VALUES ('E18/0002', 'dummy2', 'dummy2', '1997-08-12', 'M', '123', '123', 'ab@ab.com', 'abcd', true);
INSERT INTO `employee_portal`.`employee` (`emp_code`, `first_name`, `last_name`, `dob`, `gender`, `primary_contact_number`, `secondary_contact_number`, `email_id`, `password`, `enabled`) VALUES ('E18/0003', 'dummy3', 'dummy3', '1997-08-19', 'F', '123', '123', 'abc@abc.com', 'abcd', true);
INSERT INTO `employee_portal`.`employee` (`emp_code`, `first_name`, `last_name`, `dob`, `gender`, `primary_contact_number`, `secondary_contact_number`, `email_id`, `password`, `enabled`) VALUES ('E18/0004', 'dummy4', 'dummy4', '1997-08-2', 'M', '123', '123', 'b@b.com', 'abcd', true);
INSERT INTO `employee_portal`.`employee` (`emp_code`, `first_name`, `last_name`, `dob`, `gender`, `primary_contact_number`, `secondary_contact_number`, `email_id`, `password`, `enabled`) VALUES ('E18/0005', 'dummy5', 'dummy5', '1997-08-12', 'F', '123', '123', 'bb@bb.com', 'abcd', true);
SELECT * FROM employee;


SELECT * FROM job_title_master;
INSERT INTO `employee_portal`.`job_title_master` (`job_id`, `job_title`) VALUES (1, 'GET-Trainee');
INSERT INTO `employee_portal`.`job_title_master` (`job_id`, `job_title`) VALUES (2, 'Team Leader');
INSERT INTO `employee_portal`.`job_title_master` (`job_id`, `job_title`) VALUES (3, 'Manager');


INSERT INTO `employee_portal`.`project` (`project_id`, `project_name`, `project_description`, `start_date`, `end_date`) VALUES (1, 'Training', 'abc', '2018-12-12', '2019-12-12');
INSERT INTO `employee_portal`.`project` (`project_id`, `project_name`, `project_description`, `start_date`, `end_date`) VALUES (2, 'Testing', 'abc', '2018-12-12', '2019-12-12');
INSERT INTO `employee_portal`.`project` (`project_id`, `project_name`, `project_description`, `start_date`, `end_date`) VALUES (3, 'Training1', 'abc', '2018-12-12', '2019-12-12');
INSERT INTO `employee_portal`.`project` (`project_id`, `project_name`, `project_description`, `start_date`, `end_date`) VALUES (4, 'Training2', 'abc', '2018-12-12', '2019-12-12');
INSERT INTO `employee_portal`.`project` (`project_id`, `project_name`, `project_description`, `start_date`, `end_date`) VALUES (5, 'Training3', 'abc', '2018-12-12', '2019-12-12');
SELECT *FROM project;

INSERT INTO `employee_portal`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `curr_proj_id`) VALUES (1, 'E18/0000', 2, 1);
INSERT INTO `employee_portal`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `curr_proj_id`) VALUES (2, 'E18/0000', 3, 1);
INSERT INTO `employee_portal`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `reproting_mgr`, `team_lead`, `curr_proj_id`) VALUES (3, 'E18/0001', 1, 'E18/0001', 'E18/0002', 2);
INSERT INTO `employee_portal`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `reproting_mgr`, `team_lead`, `curr_proj_id`) VALUES (4, 'E18/0001', 2, 'E18/0002', 'E18/0000', 2);
INSERT INTO `employee_portal`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `reproting_mgr`, `team_lead`, `curr_proj_id`) VALUES (5, 'E18/0001', 1, 'E18/0000', 'E18/0001', 2);
select * from job_details;

