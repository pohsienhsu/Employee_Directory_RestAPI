package com.springproject.cruddemo.service;

import com.springproject.cruddemo.dao.EmployeeDAO;
import com.springproject.cruddemo.entity.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }
}
