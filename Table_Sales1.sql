create table Products_Credit_Sales_Master(
credit_sales_billno int(15) PRIMARY KEY,
credit_sales_date date,
retailer_idno int(15) REFERENCES Retailers_Master
);

