## ONLINE BOOK-STORE API
    
## Table of Contents

# Overview
# Features
# Technology Stack
# Run The App
# Authentication
# Unit Tests
# Docs
# License


    Overview 

the Online Bookstore API is a backend solution 
 designed to facilitate the management of an online bookstore.
It allows users to view available books, 
add new books to the store, update book details,
delete books from the inventory, and search for books by UUID. 
The API is built using Java with the Spring Boot framework, 
providing a robust and scalable solution for bookstore management. 
Authentication is implemented using JSON Web Tokens (JWT) 
with Spring Security to secure access to the API endpoints.

    Features
* Login to the application
* View a list of available books 
* Add new books to the store 
* Update book details *Delete books from the store 
* Search for books by UUID 
* Secure authentication with JWT and Spring Security

     
    Technology Stack:

The technology stack utilized in this project includes: 
* Java with Spring Boot framework for API development 
* Relational database (PostgresSQL) for data storage 
* JPA for database interactions *JSON Web Tokens (JWT) for authentication 
* Spring Security for access control

Run The App To run the Online Bookstore API, follow these steps:

    Clone the repository:
    git clone <repository_url>

Navigate to the project directory:
cd <project_directory>

      Build the project:
       ./gradlew build

    Run the application:
    ./gradlew bootRun

   ### Default Login Details
Use the following inbuilt login credentials to obtain a JWT token:
- **Username: user**
- **Password: password**

To authenticate, send a POST request to the /login endpoint 
with the above credentials. You will receive a JWT token in the response,
which should be included in the Authorization header of subsequent requests.


  ## Authentication: 
Authentication is implemented using JSON Web Tokens (JWT) 
with Spring Security to secure access to the API endpoints. 
Upon successful authentication, users receive 
a JWT token that must be included in subsequent requests 
to access protected resources.

  ## Unit Tests: 
Unit tests have been written to ensure the correctness 
and reliability of the Online Bookstore API. 
These tests cover critical components of the application,
including API endpoints, service layer logic, and data access operations. 
To run the unit tests, execute the following command:
    
    ./gradlew test


    Docs API Documentation: 
* GET /books/ - Retrieve a list of available books. 
* POST /books/- Add a new book to the store. 
* PUT /books/{id} - Update book details. 
* DELETE /books/{id} - Delete a book from the store. 
* GET /books/{uuid} - Find a book by UUID.

License The Online Bookstore API is open-source and released under the MIT License. 
Feel free to modify and use the code per the license terms.