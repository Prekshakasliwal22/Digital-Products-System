use Digital_Products;
create table Outlets_Payments(
paid_payment_entryno int(10) primary key,
paid_payment_date date,
outlet_idno int(10) references Company_Outlets_Master,
paid_payment_amount int(10),
mode_of_payment varchar(40),
against_reference varchar(60)
);

