School Management System
========================

This is a School Management System that allows students to take zero or more courses. Each course has a course name, course code, and credit score. Instructors could instruct at least one or more courses and each instructor has a name, an address, and a phone number. A course could be instructed by only one instructor. There are two types of instructors: permanent instructor and visiting researcher, but a visiting researcher takes an hourly salary, and a permanent instructor takes a fixed salary.

UML Diagram
-----------

![UML Diagram](https://github.com/dilgekarakas/StudentManagementSystem/blob/master/uml.png)

JPA Project Configuration
-------------------------

To prepare/configure a JPA project, I have created a `persistence.xml` file as a configuration file.

Java Classes (Model)
--------------------

Here are the appropriate java classes for this use case and the dependencies/relations between each other:

-   Student
    -   name
    -   address
    -   gender
    -   birth date
    -   courses (zero or more)
-   Course
    -   course name
    -   course code
    -   credit score
    -   instructor (one)
-   Instructor
    -   name
    -   address
    -   phone number
-   VisitingResearcher
    -   hourly salary
-   PermanentInstructor
    -   fixed salary

Running the Project
-------------------

To run the project, you need to:

1.  Configure a MySQL database and create a schema.
2.  Update the database connection details in the `persistence.xml` file.
3.  Run the `TestStudentManagementApp` class.

The project is built using Maven, so you can easily import it into your IDE and build it from there.

Usage
-----

To run the project, execute the `TestStudentManagementApp` class, which performs the following operations:

1.  Checks if there is any existing data in the database. If not, it saves test data to the database.
2.  Finds and displays all the students in the database.
3.  Finds and displays a specific student by ID.
4.  Deletes the student that was found in the previous step.

The project includes the following packages:

-   `edu.sabanciuniv.controller`: Contains the `StudentController` class, which provides the CRUD operations for the `Student` entity.
-   `edu.sabanciuniv.model`: Contains the model classes for the entities `Student`, `Course`, `Instructor`, `PermanentInstructor`, and `VisitingInstructor`.
-   `edu.sabanciuniv.utility`: Contains the `EntityManagerUtils` class, which provides utility methods for managing the entity manager.
