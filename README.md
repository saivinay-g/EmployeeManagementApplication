# Employee Payroll Management System

A simple console-based Employee Payroll Management System built using Spring Boot, Spring JDBC, and an in-memory database. This application allows you to manage employee records including adding, updating, viewing, and deleting employees, as well as finding the highest paid employee.

---

## Features

- Add new employees to the payroll system.
- Update employee details (name, department, designation, salary, date of joining).
- Delete employee records by ID.
- View all employee records.
- Search for an employee by ID.
- View the highest paid employee currently in the system.
- **In-memory storage:** All data is stored temporarily and resets on application restart.

---

## Technology Stack

- Java 17+
- Spring Boot
- Spring JDBC
- H2 In-memory Database
- Maven or Gradle

---

## Getting Started

### Prerequisites

- Java JDK 17 or above
- Maven or Gradle installed
- IDE (IntelliJ, Eclipse) or terminal

### Running the Application

1. **Clone the repository:**
   git clone <your-repo-url>
   cd employeepayrollmanagementsystem

text

2. **Build the project:**
   mvn clean install

text
_or with Gradle:_
gradle build

text

3. **Run the application:**
   mvn spring-boot:run

text
_or execute the generated JAR:_
java -jar target/employeepayrollmanagementsystem-0.0.1-SNAPSHOT.jar

text

### Usage

The application is fully console-driven. On startup you’ll see:
===== Employee Payroll Management System =====

Add New Employee

Update Employee

Delete Employee by ID

View All Employees

Find Employee by ID

View Highest Paid Employee

Exit
Enter your choice:

text
Follow the prompts to interact with the system and manage employees.

---

## Project Structure

- `Main.java` - Entry point and menu interface.
- `model/Employee.java` - Employee entity/model.
- `service/EmployeeService.java` - Business logic and employee operations.
- `repository/EmployeeRepository.java` - Persistence layer using Spring JDBC.
- `resources/application.properties` - Configuration, including in-memory DB setup.

---

## Configuration

No setup is required other than placing your SQL files in the correct location.  
Simply define your table structure in a `schema.sql` file (required).  
If you want pre-populated sample data, add a corresponding `data.sql` file (optional).

Both files must be located in the `src/main/resources` folder.

Spring Boot will automatically execute these files at startup to initialize your in-memory H2 database—no additional configuration is necessary.

All data is lost on shutdown since it’s stored in-memory. To persist data, switch to an external database by updating the datasource settings.

---

## Contributing

Pull requests are welcome! For major changes, please open an issue first.

---

## License

Distributed under the MIT License. See `LICENSE` for details.

---

## Author
Sai Vinay