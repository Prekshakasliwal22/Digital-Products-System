use Digital_Products;
CREATE TABLE Digital_Products_Master (
    digital_product_idno INT PRIMARY KEY,
    product_type VARCHAR(25) NOT NULL,
    brand_name VARCHAR(25) NOT NULL,
    model_no_name VARCHAR(20) NOT NULL,
    technical_info VARCHAR(60),
    product_size_capacity VARCHAR(25),
    std_cost INT, 
    gst_in_per DECIMAL(5, 2) 
);