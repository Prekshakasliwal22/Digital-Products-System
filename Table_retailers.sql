use Digital_Products;
create table Retailers_Master(
retailer_idno int(4) PRIMARY KEY,
retailer_firmname varchar(30) NOT NULL,
address varchar(75),
city varchar(15),
owner_name varchar(25),
mobile_no bigint,
email_id varchar(25)
);
INSERT INTO Retailers_Master
(retailer_idno, retailer_firmname, address, city, owner_name, mobile_no, email_id)
VALUES
(1, 'Tech World Electronics', '12 FC Road, Shivajinagar', 'Pune', 'Rohit Mehta', 9876543210, 'techworld@gmail.com'),
(2, 'Digital Zone Retailers', '45 MG Road, Camp Area', 'Pune', 'Priya Nair', 9823456789, 'digitalzone@gmail.com'),
(3, 'City Electronics', '7 Tilak Road, Camp Area', 'Pune', 'Neha Nikam', 9845789654, 'cityelectronics@yahoo.com'),
(4, 'Home Tech Appliances', '22 Laxmi Nagar Main Road', 'Nagpur', 'Arjun Patil', 9890876543, 'hometech@rediffmail.com'),
(5, 'ElectroMart', 'Plot 78, Central Avenue', 'Nagpur', 'Vivek Kulkarni', 9812356890, 'electromart@gmail.com'),
(6, 'Mega Home Store', '65 Naupada, Thane West', 'Thane', 'Rajesh Jain', 9823154321, 'megastore@outlook.com'),
(7, 'Smart Choice Electronics', '18 Carter Road', 'Mumbai', 'Sneha Shah', 9812345678, 'smartchoice@gmail.com');
