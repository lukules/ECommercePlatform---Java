# E-commerce Platform Simulator

This project is a simple console-based e-commerce platform simulator, developed as a hands-on exercise to learn and practice core and modern Java concepts.

## About This Project

The primary goal of this project was to create a comprehensive application to gain a practical understanding of the Java language, from fundamental Object-Oriented Programming (OOP) principles to more advanced features like the Stream API. The system simulates the basic functionalities of an online store, where users can register, log in, browse products, add them to a shopping cart, and place orders.



## Core Features Implemented

*   **User Management:** Basic user creation and a simple login mechanism.
*   **Product Catalog:** Ability to add and display products.
*   **Inheritance for Products:** The system supports different types of products (e.g., `ElectronicProduct`, `ClothingProduct`) using abstract classes and inheritance.
*   **Shopping Cart:** Each user has a personal shopping cart with features to:
    *   Add products (handling duplicates by increasing quantity).
    *   Remove products.
    *   Calculate the total price.
    *   Clear the cart.
*   **Order Processing:** Users can create an order from their shopping cart, which records the transaction and updates product stock levels.
*   **Modern Data Processing:**
    *   Search for products by a keyword.
    *   Sort and display all products by price.

## Key Java Concepts Covered

This project was built to practice and demonstrate understanding of the following Java concepts:

*   **Object-Oriented Programming (OOP):**
    *   Classes and Objects
    *   Encapsulation (using `private` fields with `public` getters/setters)
    *   Inheritance (with `extends`)
    *   Abstract Classes and Methods
    *   Polymorphism
    *   Overriding methods (`toString()`, `equals()`, `hashCode()`)
*   **Java Collections Framework:**
    *   `HashMap` for efficient data management (products, users, cart items).
    *   `ArrayList` for storing a list of orders.
    *   The crucial role of `equals()` and `hashCode()` when using custom objects as `HashMap` keys.
*   **Core Language Features:**
    *   Enums (for `OrderStatus`).
    *   The `java.time` API (`LocalDateTime`) for handling dates.
