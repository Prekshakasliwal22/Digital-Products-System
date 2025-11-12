use Digital_Products;
create table Products_Inward_Details(
inward_billno int(10) REFERENCES Products_Inward_Master,
digital_product_idno int(14) REFERENCES Digital_Products_Master,
inward_qty int(10),
inward_cost int(15));

SELECT * FROM Products_Inward_Details WHERE inward_billno = 1;
SELECT a.*, b.product_type, b.brand_name, b.gst_in_per
FROM Products_Inward_Details a
JOIN Digital_Products_Master b ON a.digital_product_idno = b.digital_product_idno
WHERE a.inward_billno = 1;
SELECT * FROM Products_Inward_Details; 