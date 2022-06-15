INSERT IGNORE INTO Customers(ID, EMAIL, fullname, pwd, credit_card_number, credit_card_type) 
VALUES (1, 'abc@gmail.com','Dipen Patel', '1234', '1234 5678 9101 1121', 'VISA');
INSERT IGNORE INTO Customers(ID, EMAIL, fullname, pwd, credit_card_number, credit_card_type) 
VALUES (2, 'bcd@gmail.com','Ryan Haugnald', '2345', '2345 6789 1011 1213', 'American Express');


INSERT IGNORE INTO administrators(ID, pwd) 
VALUES ('ab', 'ab');
INSERT IGNORE INTO administrators(ID, pwd) 
VALUES ('cd', 'cd');


INSERT IGNORE INTO products(productsid, brand, color, price, productname, size) 
VALUES (1, 'Nike', 'Red', 105, 'Air Jordan', 10);
INSERT IGNORE INTO products(productsid, brand, color, price, productname, size) 
VALUES (2, 'Addidas', 'Blue', 100, 'Adios Boost 2', 10.50);
INSERT IGNORE INTO products(productsid, brand, color, price, productname, size) 
VALUES (3, 'Puma', 'Yellow', 105, 'RunRepeat', 9.50);


INSERT IGNORE INTO purchases (purchase_id, date, quantity)
VALUES (1, 2022-05-01, 2);

INSERT IGNORE INTO purchases (purchase_id, date, quantity)
VALUES (2, 2022-05-02, 2);

