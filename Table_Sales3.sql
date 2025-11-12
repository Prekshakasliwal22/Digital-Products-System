use Digital_Products;
create table Products_Cash_Sales_Master(
cash_sales_billno int(25) PRIMARY KEY,
cash_sales_date date,
client_idno int(25) REFERENCES Clients_Master);
select* from Products_Cash_Sales_Master;

