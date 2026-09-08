Employee Management System

A beginner-friendly J2EE web application built with Java, JSP, Servlets, JDBC, MySQL, Maven, and Apache Tomcat.

This project was developed to understand a traditional Java web application architecture and to practice manual software testing, including functional, UI, API, database, smoke, regression, and negative testing.

📌 Project Overview

The Employee Management System allows an administrator to:

Login securely using username and password

View the employee list

Add new employees

Delete employees

Logout from the application

Store and retrieve employee data from MySQL

🛠️ Technologies Used

Technology

Purpose

Java 17

Backend programming

JSP

Web pages / UI

Jakarta Servlets

Request handling

JDBC

Database connectivity

MySQL 8

Database

Maven

Dependency and build management

Apache Tomcat 10

Application server

IntelliJ IDEA

Development environment

Postman

Manual API testing

🏗️ Project Architecture

Browser
   │
   ▼
JSP Pages
   │
   ▼
Servlets (Controller)
   │
   ▼
DAO Layer
   │
   ▼
JDBC
   │
   ▼
MySQL Database

📂 Project Structure

EmployeeManagement
│
├── pom.xml
│
└── src
    └── main
        ├── java
        │   └── com.employee
        │       ├── controller
        │       │   ├── LoginServlet.java
        │       │   ├── EmployeeServlet.java
        │       │   └── LogoutServlet.java
        │       │
        │       ├── dao
        │       │   ├── DBConnection.java
        │       │   ├── DatabaseTest.java
        │       │   └── EmployeeDAO.java
        │       │
        │       └── model
        │           └── Employee.java
        │
        └── webapp
            ├── login.jsp
            ├── dashboard.jsp
            ├── employees.jsp
            ├── employee-form.jsp
            └── WEB-INF
                └── web.xml

🗄️ Database

Database name:

employee_management

Main tables:

users — stores login credentials

employees — stores employee information

Example employee fields:

ID
Employee Code
Name
Email
Department
Salary

⚙️ Setup Instructions

1. Clone the repository

git clone <YOUR_GITHUB_REPOSITORY_URL>
cd EmployeeManagement

2. Configure MySQL

Create the database and tables:

CREATE DATABASE employee_management;

USE employee_management;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    salary DECIMAL(10,2) NOT NULL
);

INSERT INTO users (username, password)
VALUES ('admin', 'admin123');

INSERT INTO employees
(employee_code, name, email, department, salary)
VALUES
('EMP001', 'Rahul Kumar', 'rahul@gmail.com', 'IT', 45000),
('EMP002', 'Amit Sharma', 'amit@gmail.com', 'HR', 40000);

3. Configure database credentials

Update the MySQL username and password in:

src/main/java/com/employee/dao/DBConnection.java

Example:

private static final String USER = "root";
private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";

For a real production application, database credentials should be stored securely using environment variables or a secrets manager rather than committed to GitHub.

4. Build the project

Using Maven:

mvn clean package

The WAR file will be generated inside:

target/

5. Deploy on Apache Tomcat

Deploy the generated WAR file to Apache Tomcat 10.

The application context can be:

/EmployeeManagement

Then open:

http://localhost:8080/EmployeeManagement/

or:

http://localhost:8080/EmployeeManagement/login.jsp

🔐 Demo Login

Username: admin
Password: admin123

🧪 Manual Testing

This project is also used as a manual testing practice project.

Testing Areas

Functional Testing

Login with valid credentials

Login with invalid credentials

View employees

Add employee

Delete employee

Logout

Session/access control

UI Testing

Verify labels and fields

Verify buttons and links

Verify form fields

Verify navigation

Verify error messages

Verify page layout

API Testing

API/request testing can be performed manually using Postman for the application's HTTP endpoints.

Examples:

POST /login
GET  /employees
POST /employees
GET  /employees?action=delete&id=1
GET  /logout

Database Testing

Using MySQL:

SELECT * FROM users;
SELECT * FROM employees;

Verify that:

Newly added employees are stored correctly

Deleted employees are removed

Employee information matches the UI

Duplicate employee codes are handled correctly

Negative Testing

Examples:

Empty username

Empty password

Invalid login credentials

Invalid email

Empty employee name

Empty employee code

Duplicate employee code

Invalid salary

Unauthorized access to protected pages

Regression Testing

After a change, previously working functionality should be retested:

Login → Dashboard → View Employees → Add Employee → Delete Employee → Logout

📝 Sample Test Case

Test Case

Steps

Expected Result

Valid Login

Enter valid username/password and click Login

Dashboard should open

Invalid Login

Enter incorrect credentials

Error message should be displayed

Add Employee

Enter valid employee details and submit

Employee should appear in employee list

Duplicate Code

Enter an existing employee code

Employee should not be duplicated

Delete Employee

Click Delete for an employee

Employee should be removed

Logout

Click Logout

User should return to login page

🐞 Defect Reporting

Defects can be documented with:

Defect ID
Title
Module
Severity
Priority
Environment
Steps to Reproduce
Expected Result
Actual Result
Status

Example:

Defect ID: DEF-001
Title: Duplicate employee code can be submitted
Module: Employee Management
Severity: Medium
Priority: High
Status: Open

🎯 Learning Objectives

This project demonstrates practical understanding of:

J2EE web application structure

JSP and Servlets

JDBC and MySQL

MVC-style separation

HTTP request/response flow

Session management

CRUD operations

Manual functional testing

UI testing

API testing using Postman

SQL/database validation

Negative testing

Regression testing

Defect reporting

🚀 Future Improvements

Possible future enhancements:

Employee update functionality

Search and filtering

Pagination

Better validation and error handling

Role-based access

Password hashing

Improved UI

Automated testing in a future version

👨‍💻 Author

Roshan Kumar

This project is created for learning and demonstrating Java web development and manual software testing skills.

📄 License

This project is intended for educational and portfolio purposes.
