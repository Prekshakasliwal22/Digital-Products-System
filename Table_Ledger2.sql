create table Retailers_Ledger(
retailer_idno int(20) REFERENCES Retailers_Master,
balance_amount int(25));
