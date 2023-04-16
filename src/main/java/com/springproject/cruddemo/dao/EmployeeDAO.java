package com.springproject.cruddemo.dao;

import com.springproject.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
