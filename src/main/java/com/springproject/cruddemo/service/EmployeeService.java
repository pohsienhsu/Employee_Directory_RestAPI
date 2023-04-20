package com.springproject.cruddemo.service;


import com.springproject.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int employeeId);

    public void save(Employee employee);

    public void deleteById(int employeeId);
}
