create table Company_Outlets_Ledger(
outlet_idno int(20) REFERENCES Company_Outlets_Master,
balance_amount int(25));
