-- Create Database
CREATE DATABASE employeedb;
USE employeedb;

-- =========================
-- EMPLOYEES TABLE
-- =========================
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(100),
    emp_code VARCHAR(50) UNIQUE,
    department VARCHAR(100),
    salary DOUBLE
);

-- =========================
-- SAMPLE DATA (OPTIONAL)
-- =========================
INSERT INTO employees (emp_name, emp_code, department, salary) VALUES
('Kavya', 'EMP001', 'IT', 25000),
('Rahul', 'EMP002', 'HR', 20000),
('Anjali', 'EMP003', 'Finance', 30000);
