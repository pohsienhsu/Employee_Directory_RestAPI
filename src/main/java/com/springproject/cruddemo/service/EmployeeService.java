package com.springproject.cruddemo.service;

import com.springproject.cruddemo.dao.EmployeeRepository;
import com.springproject.cruddemo.entity.Employee;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public Employee findEmployeeById(ObjectId employeeId) {
        Optional<Employee> result = this.employeeRepository.findById(employeeId);
        Employee employee;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Can't find employee id: " + employeeId);
        }
        return employee;
    }

    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    public void deleteEmployee(ObjectId employeeId) {
        this.employeeRepository.deleteById(employeeId);
    }
}
