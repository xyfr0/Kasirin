/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  jabba
 * Created: Jul 1, 2025
 */

--DROP TABLE Categories, Orders, Products, Transactions, OrderItems, UserShifts, Shifts, UserRoles, Users, Roles
USE KASIRIN

CREATE TABLE Roles
(
  role_id VARCHAR(10) NOT NULL PRIMARY KEY,
  role_name VARCHAR(20) NOT NULL, 
);

CREATE TABLE Users
(
  user_id VARCHAR(10) NOT NULL PRIMARY KEY,
  username VARCHAR(25) NOT NULL,
  password VARCHAR(25) NOT NULL,
  fullname VARCHAR(100) NOT NULL,
  register_date DATETIME NOT NULL DEFAULT SYSUTCDATETIME(),  
);

CREATE TABLE UserRoles
(
  role_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Roles(role_id),
  user_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Users(user_id),    
);

CREATE TABLE Shifts
(
  shift_id VARCHAR(10) NOT NULL PRIMARY KEY,
  shift_start TIME NOT NULL,
  shift_end TIME NOT NULL,  
);

CREATE TABLE UserShifts
(  
  shift_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Shifts(shift_id),
  user_id VARCHAR(10) NOT NULL FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE OrderItems
(
  orderitem_id VARCHAR(10) NOT NULL PRIMARY KEY,
  quantity INT NOT NULL,
  unit_price MONEY NOT NULL,
  total_price AS (quantity * unit_price) PERSISTED,  
);

CREATE TABLE Transactions
(
  transaction_id INT NOT NULL PRIMARY KEY,
  payment_method INT NOT NULL,
  transaction_date DATETIME NOT NULL DEFAULT SYSUTCDATETIME(),
  amount_paid INT NOT NULL,  
);

CREATE TABLE Products
(
  product_id VARCHAR(10) NOT NULL PRIMARY KEY,
  product_name VARCHAR(25) NOT NULL,
  unit_price MONEY NOT NULL,
  current_stock INT NOT NULL,
  register_date DATETIME NOT NULL DEFAULT SYSUTCDATETIME(),
  orderitem_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES OrderItems(orderitem_id),    
);

CREATE TABLE Orders
(
  order_id INT NOT NULL PRIMARY KEY,
  order_date DATETIME NOT NULL DEFAULT SYSUTCDATETIME(),
  total_amount INT NOT NULL,
  orderitem_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES OrderItems(orderitem_id),
  user_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Users(user_id),
  transaction_id INT NOT NULL FOREIGN KEY REFERENCES Transactions(transaction_id),        
);

CREATE TABLE Categories
(
  category_id VARCHAR(10) NOT NULL PRIMARY KEY (category_id),
  category_name VARCHAR(15) NOT NULL,
  description VARCHAR(255),
  product_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Products(product_id),    
);