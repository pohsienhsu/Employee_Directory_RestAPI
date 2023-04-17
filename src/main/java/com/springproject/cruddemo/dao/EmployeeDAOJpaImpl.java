package com.springproject.cruddemo.dao;

import com.springproject.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = this.entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int employeeId) {
        // get the employee
        Employee employee = this.entityManager.find(Employee.class, employeeId);
        // return the employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // save employee (merge is either save or update)
        Employee savedEmployee = this.entityManager.merge(employee);
        // return the updatedEmployee
        return savedEmployee;
    }

    @Override
    public void deleteById(int employeeId) {
        Employee employee = this.entityManager.find(Employee.class, employeeId);
        this.entityManager.remove(employee);
    }
}
