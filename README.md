### ONLINE BOOK-STORE API

Welcome to the Online Bookstore API, 
a comprehensive backend solution designed for managing an online bookstore. 
This API allows you to handle various bookstore operations such as seamlessly 
viewing available books, adding new books, updating book details, 
deleting books from inventory, and searching for books by UUID. 
The API ensures secure access to endpoints using JSON Web Tokens (JWT) 
for authentication and provides robust and scalable performance through 
the use of the Spring Boot framework.
Whether you're building a new bookstore application or integrating with an existing one,
the Online Bookstore API offers the features and reliability you need.

## Table of Contents

# Overview
# Features
# Technology Stack
# Run The App
# Authentication
# Unit Tests
# Docs
# License


###  Overview 

the Online Bookstore API is a backend solution 
it is designed to facilitate the management of an online bookstore.
It allows users to view available books, 
add new books to the store, update book details,
delete books from the inventory, and search for books by UUID. 
The API is built using Java with the Spring Boot framework, 
it provides a robust and scalable solution for bookstore management. 
Authentication is implemented using JSON Web Tokens (JWT) 
with Spring Security to secure access to the API endpoints.

### Features
* Login 
* View a list of available books 
* Add new books to the store 
* Update book details *Delete books from the store 
* Search for books by UUID 
* Secure authentication with JWT and Spring Security
------------------
### Technology Stack:

The technology stack utilized in this project includes: 
* Java with Spring Boot framework for API development 
* Relational database (PostgresSQL) for data storage 
* JPA for database interactions 
* JSON Web Tokens (JWT) for authentication 
* Spring Security for access control

--------------
  **Clone the repository:**
    ```sh
    git clone <repository_url>
    ```

  **Navigate to the project directory:**
    ```sh
    cd <project_directory>
    ```

   **Build the project:**
    ```sh
   mvn clean install
    ```
    
   **Run the application:**
    ```sh
   mvn spring-boot:run
    ```

   ### Default Login Details
Use the following inbuilt login credentials to obtain a JWT token:
- **Username: user**
- **Password: password1**

To authenticate, send a POST request to the /login endpoint 
with the above credentials. You will receive a JWT token in the response,
which should be included in the Authorization header of subsequent requests.

  ## Authentication: 
Authentication is implemented using JSON Web Tokens (JWT) 
with Spring Security to secure access to the API endpoints. 
Upon successful authentication, users receive 
a JWT token that must be included in subsequent requests 
to access protected resources.

----------------
  ## Unit Tests: 
I wrote unit tests to ensure the correctness 
and the reliability of the Online Bookstore API. 
These tests cover critical components of the application,
which includes the API endpoints, service layer logic, and data access operations. 
To run the unit tests, execute the following command:
```sh
 mvn test

```
-------------
## Docs API Documentation: 
* GET /books/ - Retrieve a list of available books. 
* POST /books/- Add a new book to the store. 
* PUT /books/{id} - Update book details. 
* DELETE /books/{id} - Delete a book from the store.
GET /books/{uuid} - Find a book by UUID

...........
* GET /authors/ - Retrieve a list of available authors.
* POST /authors/ - Add a new author to the store.
* PUT /authors/{id} - Update author details.
* DELETE /authors/{id} - Delete an author from the store.
* GET /authors/{uuid} - Find an author by UUID.

.............
*  GET /genres/ - Retrieve a list of available genres.
*  POST /genres/ - Add a new genre to the store.
*  PUT /genres/{id} - Update genre details.
*  DELETE /genres/{id} - Delete a genre from the store.
*  GET /genres/{uuid} - Find a genre by UUID
---------------
License The Online Bookstore API is open-source and released under the MIT License. 
Feel free to modify and use the code per the license terms.
