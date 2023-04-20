# Employee Directory RestAPI

A project utilizing Spring Boot and Maven to create an Restful API that supports CRUD capability for the Rest clients.
The sample data is stored in MySQL server along with Hibernate JPA to access the data. The purpose of this project is to
build a demo API that supports creating, reading, updating and deleting the employees directory info.

### API Structure
Employee REST Controller <=> Employee Service <=> Employee Repository <=> Database (MySQL)

<img src="src/main/resources/static/images/Revised_API_FlowChart.png"  width="900" height="100">

- Employee REST Controller:

  The REST Controllers handle the HTTP requests and responses from the REST clients and the return packages from the
Employee Service respectively.

- Employee Service:

  The Employee Services manage service layer and the transactional aspect of the CRUD actions with the database. That is to say, the services
would also call the corresponding methods from the DAO.

> The API had been refactored to use the Spring Data Rest dependency to have the Rest Controllers and Services out of box
> without the boilerplates. The dependencies are shown in the pom file.

- Employee Repository:

  The Employee Repository was refactored from writing our own DAO (Data Access Object). The JPA Repository comes with 
standard CRUD functions, including findAll(), save, deleteById(), etc. The Employee Repository would retrieve the data 
from the databases.

### REST Endpoints

The project's endpoints are currently at the default localhost port 8080.

http://localhost:8080/api

| HTTP Method | Endpoint                | Description                         |
|:-----------:|:------------------------|:------------------------------------|
|     GET     | /employees              | gets a list of all employees        |
|     GET     | /employees/{employeeId} | get an employees based on ID        |
|    POST     | /employees              | create/insert an new employee       |
|     PUT     | /employees/{employeeId} | update an existing employee with ID |
|   DELETE    | /employees/{employeeId} | delete an employee based on ID      |

### Security

The Employee API utilizes Spring Security and bcrypt for password hashing. The users' info is stored in the SQL database,
and the bcrypt password is generated through this [website](https://www.bcryptcalculator.com/encode). In addition, each
user would also have specific security roles that would have access to different API methods. As listed in the table below:

<img src="src/main/resources/static/images/Spring_Security_FlowChart.png"  width="900" height="100">

> The Spring Security would compare the plain-text password the user input through the login form and hash it using bcrypt.
> Since bcrypt is a one-way encoded algorithm, Spring Security can't decode the hashed password in the database. Therefore,
> it compares the hashed input to the hashed password in the database.

| Roles    | Authorization                       |
|:---------|:------------------------------------|
| employee | access to GET employee info         |
| manager  | access to create/update an employee |
| admin    | access to DELETE an employee        |






  

