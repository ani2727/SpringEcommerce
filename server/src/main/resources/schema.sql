CREATE TABLE IF NOT EXISTS product (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255),
    desc TEXT,
    price DECIMAL(10, 2),
    quantity INT,
    category VARCHAR(255),
    release_Date DATE,
    available BOOLEAN
);
