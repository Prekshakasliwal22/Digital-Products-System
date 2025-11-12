create table Retailer_Payments(
received_payment_entryno int(6) PRIMARY KEY,
received_payment_date date,
retailer_idno int(20) REFERENCES Retailers_Master,
received_payment_amount int(15),
mode_of_payment varchar(40),
against_reference varchar(60)
);
