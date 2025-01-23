# Banking Application Project

## Description

This project involves the enhancement of a `BankingAccount.java` class which implements a basic banking interface with methods like `deposit`, `withdraw`, and others. The main objectives were:

- **Improve the Banking Code by Adding Data Structures:**
  - Utilized collections within `BankingAccount` to keep track of operations, implementing `List<Operation> operationHistory` to log all transactions related to each account. This was achieved with `private List<Operation> operationHistory = new ArrayList<>();`.
  - In the `Bank` class, used a `Map` to manage accounts, `private Map<Integer, IBankAccount> accounts = new LinkedHashMap<>();`, ensuring order of insertion for account management.

- **Implement Input/Output:**
  - Transformed the application into an interactive console application by incorporating user input and output functionalities. If there was minimal interaction the previous day, this day included more interaction.
  - Added the ability to generate reports of account operations, saving these logs in `.txt` files within an `output_txt_reports` directory.

To make the project more engaging and to adhere to good programming practices like **High Cohesion**, additional classes were introduced:

- **BankingUI:** Manages the user interface, handling user interactions through the console.
- **Bank:** Acts as the central manager for all bank accounts, utilizing the `LinkedHashMap` for maintaining order and providing methods to interact with accounts.
- **Operation:** Represents individual banking operations for logging purposes.
- **Main:** Serves as the entry point of the application where the main logic flow is orchestrated.
- **BankingAccount:** The core class, now enhanced with operation history logging.

By somewhat complicating the original task, the goals were met:

- Effective use of data structures for managing account operations and bank accounts.
- Development of an interactive console application that takes user inputs and saves operation results to text files, enhancing both the functionality and the learning experience of the project.

This project serves as a simple demonstration of banking functionalities with an emphasis on good coding practices and data management in Java.
