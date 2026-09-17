# Vedansh Singh Tomar

### 25BAI11509.Project

### VITyarthi Assignment

# Campus Lost & Found System

## About the Project

Campus Lost & Found System is a Java command-line application made to help students report and find lost or found items on campus.

Users can add lost/found items, search for items, submit claim requests, and mark items as returned. Item records are saved using file handling.

## Problem Statement

Students often lose or find belongings around campus and it can be difficult to find the correct owner through informal communication.

This project provides a simple centralized system for maintaining lost and found item records.

## Main Features

- Report a lost item
- Report a found item
- Search items by name, category, or location
- View all reported items
- Claim a found item
- Mark an item as returned
- View personal reports
- Create a student profile
- View claim requests
- Generate a summary report
- Save and load item data using file handling

## Java Concepts Used

- Classes and Objects
- Encapsulation
- Constructors
- Methods
- ArrayList
- Loops and Conditional Statements
- Switch Case
- Exception Handling
- File Handling
- String Processing
- Object-Oriented Programming

## Project Structure

```text
CampusLostAndFound/
│
├── src/
│   ├── Main.java
│   ├── Item.java
│   ├── ItemManager.java
│   ├── InputHelper.java
│   ├── User.java
│   ├── ClaimRequest.java
│   └── ReportGenerator.java
│
├── data/
│   └── items.txt
│
├── README.md
└── statement.md
Requirements
Java JDK
Command Prompt / Terminal

Check Java installation:

java -version
javac -version
How to Run
1. Clone the repository
git clone https://github.com/vedansh25bai11509-pixel/CampusLostAndFound.git
2. Open the project folder
cd CampusLostAndFound
3. Compile the project
javac -d out src\*.java
4. Run the application
java -cp out Main

The main menu will then be displayed.

Data Storage

The application stores item records in:

data/items.txt

The program loads saved item records when it starts and saves changes while the application is running.

Validation

The application includes basic validation such as:

Empty input is not accepted for required fields.
Item IDs must be numeric.
Invalid menu choices are handled.
Non-existent items cannot be claimed.
Only found items can be claimed.
Already returned items cannot be returned again.
Testing

The following features were tested:

Lost item reporting
Found item reporting
Item ID generation
Item searching
Claim requests
Return status
Personal reports
Student profile
Summary report
File saving and loading
Invalid input handling
Future Enhancements
Database integration
Student login and authentication
Admin dashboard
Automatic lost/found item matching
Image upload
Notifications
Web or mobile interface
Student Details

Name: Vedansh Singh Tomar
Registration Number: 25BAI11509
Branch: B.Tech CSE (Artificial Intelligence & Machine Learning)
Year: 2nd Year
Course: Java Programming

References
Java Documentation
VITyarthi Assignment Guidelines
Java Programming Course Material
