create database electricityBillingdb;
use electricityBillingdb;

-- user table:

CREATE TABLE Users 
(
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contact_number VARCHAR(10),
    address VARCHAR(255),
    country VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    
);


-- Electricity usage Table:

CREATE TABLE Electricity_Usage
(
    usage_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    units_consumed FLOAT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);


-- Billing Table:

CREATE TABLE Billing 
(
    bill_id INT PRIMARY KEY AUTO_INCREMENT,
    usage_id INT,
    user_id INT,
    units_consumed FLOAT,
    rate_per_unit FLOAT DEFAULT 5.0,
    total_amount FLOAT GENERATED ALWAYS AS (units_consumed * rate_per_unit) STORED,
    billing_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    due_date DATE NOT NULL,
    status ENUM('Pending', 'Paid') DEFAULT 'Pending',
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (usage_id) REFERENCES Electricity_Usage(usage_id) ON DELETE SET NULL
);

-- Payment Table:

CREATE TABLE Payments 
(
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    bill_id INT,
    user_id INT,
    amount_paid FLOAT NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_method ENUM('Credit Card', 'Debit Card', 'Net Banking', 'UPI') NOT NULL,
    transaction_id VARCHAR(100) UNIQUE,
    FOREIGN KEY (bill_id) REFERENCES Billing(bill_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- Receipts Table:

CREATE TABLE Receipts
(
    receipt_id INT PRIMARY KEY AUTO_INCREMENT,
    payment_id INT,
    user_id INT,
    receipt_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    receipt_amount FLOAT,
    FOREIGN KEY (payment_id) REFERENCES Payments(payment_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

