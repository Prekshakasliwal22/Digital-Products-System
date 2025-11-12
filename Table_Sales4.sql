create table Products_Cash_Sales_Details(
cash_sales_billno int(25) REFERENCES Products_Cash_Sales_Master,
digital_product_idno int(25) REFERENCES Digital_Products_Master,
cash_sales_qty int(25),
cash_sales_cost int(25));
select* from Products_Cash_Sales_Details;

