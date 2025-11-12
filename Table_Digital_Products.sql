create database Digital_Products;
use Digital_Products;

create table Digital_Products_Master(
digital_product_idno int(4) PRIMARY KEY,
product_name varchar(25) NOT NULL,
brand_name varchar(25) NOT NULL,
model_no_name varchar(20) NOT NULL,
technical_info varchar(60),
product_size_capacity varchar(25),
std_cost int(6),
additional_info varchar(40));


ALTER TABLE Digital_Products_Master 
MODIFY product_name VARCHAR(50) NOT NULL,
MODIFY brand_name VARCHAR(40) NOT NULL,
MODIFY model_no_name VARCHAR(40) NOT NULL,
MODIFY technical_info VARCHAR(200),
MODIFY product_size_capacity VARCHAR(50),
MODIFY std_cost INT(10),
MODIFY additional_info VARCHAR(100);

delete from Digital_Products_Master ;
