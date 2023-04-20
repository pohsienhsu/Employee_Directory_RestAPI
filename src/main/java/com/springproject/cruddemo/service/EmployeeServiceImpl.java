package com.springproject.cruddemo.service;

import com.springproject.cruddemo.dao.EmployeeRepository;
import com.springproject.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);

        Employee employee;

        if (result.isPresent()) {
            employee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + employeeId);
        }

        return employee;
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int employeeId) {
        this.employeeRepository.deleteById(employeeId);
    }
}
