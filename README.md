# Employee Directory RestAPI

A project utilizing Spring Boot and Maven to create an Restful API that supports CRUD capability for the Rest clients.
The sample data is stored in MySQL server along with Hibernate JPA to access the data. The purpose of this project is to
build a demo API that supports creating, reading, updating and deleting the employees directory info.

### API Structure
Employee REST Controller <=> Employee Service <=> Employee DAO <=> Database

- Employee REST Controller

  The REST Controllers handle the HTTP requests and responses from the REST clients and the return packages from the
Employee Service respectively.
<br/><br/>
- Employee Service

  The Employee Services manage service layer and the transactional aspect of the CRUD actions with the database. That is to say, the services
would also call the corresponding methods from the DAO.
<br/><br/>
- Employee DAO

  The Employee DAO (Data Access Object) would only retrieve the values from the databases and return them to the service
layer utilizing Hibernate JPA implementation.

  

