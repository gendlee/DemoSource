# 建库
CREATE DATABASE employee;

# 员工姓名表
CREATE TABLE employee_name(
  id varchar(8),
  first_name varchar(20),
  last_name varchar(20),
  primary key(id)
);

# 员工薪资表
CREATE TABLE employee_salary(
  id varchar(8),
  realte_id varchar(8), # 关联employee_name.id
  salary double (8, 2),
  primary key(id)
);