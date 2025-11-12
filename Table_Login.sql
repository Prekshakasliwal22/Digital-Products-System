use Digital_Products;
create table company_users_login_password(
emp_id int(4) PRIMARY KEY,
emp_name varchar(40) NOT NULL,
designation varchar(20),
mobile_no int(20),
user_name varchar(40) NOT NULL,
user_password varchar(40) NOT NULL);

alter table company_users_login_password
modify emp_name varchar(50) NOT NULL,
modify mobile_no bigint;

