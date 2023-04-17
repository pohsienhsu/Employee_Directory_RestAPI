package com.springproject.cruddemo.service;

import com.springproject.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee employee);

    void deleteById(int employeeId);
}
