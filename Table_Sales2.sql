create table Products_Credit_Sales_Details(
credit_sales_billno int(20) REFERENCES Products_Credit_Sales_Master,
digital_product_idno int(20) REFERENCES Digital_Products_Master,
credit_sales_qty int(20),
credit_sales_cost int(20));
select* from Products_Credit_Sales_Details;

