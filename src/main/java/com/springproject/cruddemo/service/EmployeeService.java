package com.springproject.cruddemo.service;

import com.springproject.cruddemo.dao.EmployeeRepository;
import com.springproject.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }
}
