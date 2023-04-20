package com.springproject.cruddemo.dao;

import com.springproject.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // JPA provided CRUD methods
}
