# Library Application (Biblioteka)

A simple Java application to manage a collection of books in a library. This project was created as a step-by-step exercise from Java Start.

## Purpose

The main purpose of this application is to demonstrate basic Java concepts, including:
- Class and object creation (`Book`, `Library`).
- Methods, constructors, and fields.
- Basic console output.

## Code Structure

- `appBiblioteka/src/Book.java`: Contains the `Book` class, which represents a single book with properties like title, author, ISBN, etc.
- `appBiblioteka/src/Library.java`: The main entry point of the application, where `Book` objects are instantiated and their information is printed to the console.

## Setup

This is a standard Java project. No special setup or external dependencies are required. You can compile and run it using a Java Development Kit (JDK).

1.  **Clone the repository:**
    ```sh
    git clone <repository-url>
    cd <repository-name>
    ```

2.  **Navigate to the source directory:**
    ```sh
    cd appBiblioteka/src
    ```

## Usage

1.  **Compile the Java files:**
    From within the `appBiblioteka/src` directory, run the following command:
    ```sh
    javac Book.java Library.java
    ```

2.  **Run the application:**
    Still in the `appBiblioteka/src` directory, run the `Library` class:
    ```sh
    java Library
    ```

You will see a list of the predefined books available in the library printed to the console.