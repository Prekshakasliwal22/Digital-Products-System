use Digital_Products;
create table Products_Inward_Master(
inward_billno int(10) PRIMARY KEY,
inward_date date,
outlet_idno int(14) REFERENCES Company_Outlets_Master
);

SELECT * FROM Products_Inward_Details;
SELECT * FROM Digital_Products_Master;
