use Digital_Products;
create table Clients_Master(
client_idno int(4) PRIMARY KEY,
client_name varchar(30) NOT NULL,
address varchar(75),
city varchar(15),
gender char(25),
birth_date date,
mobile_no bigint,
email_id varchar(40));

