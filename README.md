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

Hibernate API Annotations
-------------------------

To make the system ready for database connection, I have used the appropriate annotations of Hibernate API. These annotations will map the java classes to the database tables.

Test Class
----------

To test the system, I have created a test class with a main method and insert test data to the MySQL database.
