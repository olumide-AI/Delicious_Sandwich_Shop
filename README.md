# Delicious Sandwich Shop CLI Application 

## Project Description 

A fully-featured command-line sandwich ordering application that allows customers
to build, customize, and order sandwiches, drinks, and chips — with receipts and 
pricing based on real-time selections.

## Table of Contents
<details>
<summary> Overview</summary>

- [Project Description](#project-description)
- [Features](#features)
- [Technologies Used](#technologies-used)
</details>

<details>
<summary> Getting Started</summary>

- [Installation](#installation)
- [Running the App](#running-the-app)
- [Folder Structure](#folder-structure)

</details>

<details>
<summary> Key Concepts</summary>

- [OOP Concepts](#oop-concepts)
- [Signature Sandwiches](#signature-sandwiches)

</details>

<details>
<summary> Testing</summary>

- [Unit Testing](#unit-testing)

</details>

<details>
<summary> Author</summary>

- [About Me](#about-me)

</details>

---

## Project Description

This capstone project simulates a real-world point-of-sale system for a sandwich shop. Users interact through a CLI to:

- Build custom sandwiches with bread, size, and toppings.
- Choose drinks and chips.
- View a receipt.
- Save order summaries to timestamped text files.

---

## Features

- Add Sandwich, Chips, and Drinks
- Customize toppings (meats, cheeses, sauces, veggies)
- Signature Sandwich templates
- Realistic pricing by size and topping
- Receipt file saved per order
- Clean CLI interaction
- Organized by OOP best practices

---

## Technologies Used

- Java 24 (Oracle JDK)
- Maven for build management
- JUnit 5 for unit testing
- Git & GitHub for version control
- IntelliJ IDEA (Community Edition)

---

## Installation

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/delicious-sandwich-shop.git
2. Open in IntelliJ as a Maven project

3. Compile and run

4. Follow the on-screen prompts to build your order!

## Folder Structure

src/
├── main/
│   └── java/com/delicioussandwich/
│       ├── app/              # Main entry point (Application.java)
│       ├── logic/            # Receipt generation & file saving
│       └── model/            # Core classes: Sandwich, Topping, Drink, etc.
└── test/
└── java/com/delicioussandwich/
└── model/            # Unit tests


 ## OOP Concepts
Abstraction: MenuItem and Topping are abstract superclasses

Inheritance: SignatureSandwich, PremiumTopping extend base classes

Polymorphism: Receipt uses shared interfaces for all MenuItems

Encapsulation: Order contains item logic and total calculations

 ## Signature Sandwiches
Predefined sandwiches available:
- BLT
- Philly Cheese Steak
- Buffalo Chicken
- Turkey Club
- Veggie Delight
- Maaike's Special
These extend the SignatureSandwich class and can be customized further!

## Unit Testing
JUnit tests exist for:
- SandwichTest
- DrinkTest
- ChipTest
- OrderTest
- ToppingTest

## Author: 
Olumide Kolawole





