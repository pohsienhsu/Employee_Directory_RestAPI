package com.springproject.cruddemo.dao;

import com.springproject.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // JPA provided CRUD methods

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
