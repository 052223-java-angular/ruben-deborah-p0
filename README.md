# P0 - eCommerce Project

## Table of Contents

- [Introduction](#introduction)
- [App Features](#app-features)
- [Getting Started](#getting-started)
- [Tech Stacks](#tech-stacks)
- [Development Steps](#development-steps)
- [ERD](#erd)


## Introduction

This is a Java-based command-line interface (CLI) eCommerce application. The application will be primarily built using Java and will utilize a PostgreSQL database to store the information of user, products, reviews, and carts.

## App Features

- **A user can register an account which will then create a session with the user's information.
- **A user can log in into an existing account in order to have access to their profile which contains their products and items in the cart.
- **A user can browse through products only when logged in.
- **A user is able to search for products by name, category, or price range to assist in finding what they're looking for.
- **A user can add products to my shopping cart so that I can purchase them later.
- **A user is able to modify the quantity or remove items from their cart to make it easier for them to make changes before finalizing the purchase.
- **A user is able to rate and review products in order to share their experience with other users.

- **As a user** I want to check out and pay for my order securely so that my personal and financial information is safe.
- **As a user**, I want to review my order history so that I can keep track of my purchases.
- **As a user**, I want to view ratings and reviews from other users so that I can make informed buying decisions.


## Getting Started

- [Download the installer](https://docs.oracle.com/en/java/javase/17/) for Java 17.
- [Download the installer](https://docs.docker.com/) for Docker.
- [Download the installer](https://maven.apache.org/guides/index.html) for Maven.
- [Download the installer](https://dbeaver.io/docs/) for DBeaver.
- [Download the installer](https://learning.postman.com/docs/) for Postman.
- [Download the installer](https://git-scm.com/doc) for Git Documentation.

## Tech Stacks

- **Java**: The main programming language used for building the application.
- **PostgreSQL**: Used as the database to store user, product, and order data.
- **Maven or Gradle**: Used for managing project dependencies.
- **JUnit**: A testing framework for Java applications, used to ensure our code works as expected.
- **Log4j**: A logging utility for debugging purposes.
- **JDBC (Java Database Connectivity)**: An API for connecting and executing queries on the database.
- **BCrypt**: A Java library for hashing and checking passwords for security.
- **JUnit, Mockito, and PowerMock**: Used for unit and integration testing.
- **Git and GitHub**: Used for version control.


## Development Steps

- **Git Commands**: Always make a new branch that branches from main

  `git checkout main`

  `git pull origin main`

  `git checkout -b "branch-name"`

- **Docker Setup**: Execute the PostgreSQL instance using Docker by executing the following command in your terminal. Changes can be made to the password:

```bash
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres
``` 

- **DBeaver Setup**: 
-  **In DBeaver create a postgres connection. 
-  **Username must be postgres, port: 5432, and password must be the password used to create Docker container. 
-  **Create a schema for the tables (all of which must be lowercase) which you would be used to store data. 
-  **Create new scripts and copy the ddl and dml-products under src/main/resources/db/ file path. 
-  **Then execute these scripts on your schema.

- **Application Properties**: 
-  **Create an application.properties file under src/main/resources/ file path. 
-  **Copy the following and replace the things in '' with the accurate information:
```bash
url=jdbc:postgresql://localhost:5432/postgres?currentSchema='currentSchema'
username='username'
password='password'
```

## ERD

//this part still needs to be deleted. only left it there to remember the instrctions.
- **Documentation**: The repository should include a README file with clear instructions on how to run the application. Code should be well-commented to allow for easy understanding and maintenance.

- **Scalable**: The design of the application should be scalable, allowing for easy addition of new features or modifications in the future.

