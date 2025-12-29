📚 E-Library Management System (Console Application)
👋 Introduction

This project is a console-based E-Library Management System built using core Java.
The main goal of this assignment is to demonstrate a clear understanding of creational, structural, and behavioral design patterns, along with SOLID principles, without using any frameworks, databases, or UI tools.

All data is stored in memory and is available only during the program’s execution, exactly as required.

🎯 What This Application Does

The system allows users to:

Manage books (add, update, delete, view)

Manage users (members and librarians)

Borrow books and track due dates

Receive notifications for due and overdue books (console output)

View book lists using iterators

Everything runs through a menu-driven console interface.

🧠 Key Design Decisions

Plain Java only (no Spring, no ORM, no database)

Static in-memory storage for books and users

Design patterns are implemented manually (no built-in shortcuts)

Focus on clarity, separation of concerns, and extensibility

🏗️ High-Level Architecture
Main (Console Input)
   ↓
LibraryFacade
   ↓
Commands / Services
   ↓
Singleton Registries (In-Memory)
   ↓
Observer Notifications


The Main class only handles user input.
All business logic is hidden behind a Facade, making the system easy to use and easy to extend.

📦 Package Structure
com.elibrary
 ├── Main.java
 ├── facade        → LibraryFacade (single entry point)
 ├── model         → Book, User, Member, Librarian, Loan
 ├── registry      → LibraryCatalog, UserRegistry (Singletons)
 ├── factory       → UserFactory
 ├── command       → Add, Update, Delete book commands
 ├── decorator     → ReservableBook
 ├── observer      → Loan notifications
 ├── adapter       → External notification integration
 ├── iterator      → Custom iterators for books & users
 └── util          → Logger & exceptions


This structure keeps responsibilities clearly separated and follows SOLID principles.

🧩 Design Patterns Used
🔹 Creational Patterns

Factory Method

Used to create different user roles (Member, Librarian)

Centralizes object creation logic

Singleton

LibraryCatalog and UserRegistry

Ensures a single shared in-memory data source

🔹 Structural Patterns

Facade

LibraryFacade provides a simple API for all library operations

Keeps Main clean and readable

Decorator

Adds reservation functionality to books without modifying the Book class

Demonstrates Open–Closed Principle

Adapter

Integrates an external notification service with a different interface

No changes required to existing notification logic

🔹 Behavioral Patterns

Command

Encapsulates book operations (add, update, delete) as objects

Decouples request execution from the caller

Observer

Users are notified when books are borrowed or overdue

Notifications are displayed in the console

Iterator

Custom iterators are used to traverse book and user lists

Java’s built-in iterator is intentionally not used

💾 In-Memory Data Handling

Books are stored in a static list inside LibraryCatalog

Users are stored in a static list inside UserRegistry

Loans are tracked in memory during runtime

📌 No database, no files, no persistence beyond program execution

🖥️ How to Run the Application
Prerequisites

Java 8 or higher

Steps
javac Main.java
java Main


Follow the on-screen menu to interact with the system.

🧪 Sample Console Flow
===== E-LIBRARY MANAGEMENT SYSTEM =====
1. Add Book
2. Update Book
3. Delete Book
4. View Books
5. Borrow Book
6. Check Overdue Books
7. Exit


Notifications appear automatically when relevant actions occur.

📌 Assumptions Made

Single-user, single-threaded execution

Due dates are simulated using system date

Notifications are console messages only

Data resets when the application exits

🚀 Possible Future Enhancements

Database integration

REST APIs

Real scheduling for due dates

Authentication and authorization

GUI or web interface

✅ Conclusion

This project demonstrates how a real-world problem can be solved using clean design, core Java, and well-applied design patterns.
The system is easy to understand, easy to extend, and strictly follows the assignment requirements.
