package com.springproject.cruddemo.service;

import com.springproject.cruddemo.dao.EmployeeRepository;
import com.springproject.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> result = this.employeeRepository.findById(employeeId);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + employeeId);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int employeeId) {
        this.employeeRepository.deleteById(employeeId);
    }
}
