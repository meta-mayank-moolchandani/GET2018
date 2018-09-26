create database employee_portal;

use employee_portal;


create table employees(
    emp_code VARCHAR(11) PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    dob DATE NOT NULL,
    doj DATE NOT NULL,
    gender VARCHAR(1) NOT NULL,
    primary_contact_number VARCHAR(10),
    secondary_contact_number VARCHAR(10),
    email_id VARCHAR(100) NOT NULL,
    skype_id VARCHAR(100),
    profile_picture VARCHAR(512),
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN DEFAULT true
    );

    
CREATE TABLE job_title_master(
    job_code INT PRIMARY KEY AUTO_INCREMENT,
    job_title VARCHAR(100) NOT NULL
    );
    
CREATE TABLE user_roles(
    user_role_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(200) NOT NULL,
    
    role VARCHAR(50) NOT NULL    
);

CREATE TABLE skill_master(
    skill_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    skill_name VARCHAR(100) NOT NULL
);


CREATE TABLE employee_skills(
    emp_skill_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    emp_code VARCHAR(11) NOT NULL,
    skill_code BIGINT NOT NULL,
    FOREIGN KEY (emp_code)  REFERENCES employees(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (skill_code)  REFERENCES skill_master(skill_id)  ON UPDATE CASCADE ON DELETE CASCADE
);



CREATE TABLE project_master(
    project_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description VARCHAR(200) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE
    
);

CREATE TABLE address(
    address_id INT PRIMARY KEY,
    emp_code VARCHAR(11) NOT NULL,
    add_line_1 VARCHAR(100) NOT NULL,
    add_line_2 VARCHAR(100),
    FOREIGN KEY (emp_code) REFERENCES employees(emp_code) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE job_details(
  job_detail_id INT PRIMARY KEY AUTO_INCREMENT ,
  emp_code VARCHAR(11) NOT NULL,
  job_code INT NOT NULL,
  reporting_mgr VARCHAR(11),
  team_lead VARCHAR(11),
  curr_proj_id BIGINT,
  FOREIGN KEY (emp_code) REFERENCES employees(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (job_code) REFERENCES job_title_master(job_code) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (reporting_mgr) REFERENCES employees(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (team_lead) REFERENCES employees(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (curr_proj_id) REFERENCES project_master(project_id) ON UPDATE CASCADE ON DELETE CASCADE
);

create table employee_token_fp(
  employee_token_id INT PRIMARY KEY AUTO_INCREMENT,
  emp_code VARCHAR(11) NOT NULL,
  email VARCHAR(100) NOT NULL,
  token VARCHAR(100) NOT NULL,
  FOREIGN KEY (emp_code) REFERENCES employees(emp_code) ON UPDATE CASCADE ON DELETE CASCADE
);


Insert INTo project_master (description,start_date,end_date,name) Values ("sdfhsdf",'2018-02-11','2018-08-12',"sfghgsdf");
Insert INTo job_title_master (job_title) Values ("manager");
Insert INTo skill_master (skill_name) Values ("Servlet");
INSERT INTO `employee_portal`.`employees` (`emp_code`, `first_name`, `last_name`, `dob`, `doj`, `gender`, `primary_contact_number`, `email_id`, `password`) VALUES ('E2018/C0999', 'Sankalp', 'Vyas', '1995-11-07', '2018-07-11', 'M', '', 'sankalp.vyas@metacube.com', 'asdasdsd');
INSERT INTO `employee_portal`.`job_details` ( `emp_code`, `job_code`) VALUES ('E2018/C0999', 2);

