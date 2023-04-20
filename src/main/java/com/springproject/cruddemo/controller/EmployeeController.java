package com.springproject.cruddemo.controller;

import com.springproject.cruddemo.entity.Employee;
import com.springproject.cruddemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model model) {
        // get the employees from db
        List<Employee> employees = this.employeeService.findAll();
        // add to the spring model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String addEmployee(Model model) {
        // create model attribute to bind form data
        Employee newEmployee = new Employee();

        model.addAttribute("employee", newEmployee);

        return "employees/add-employee-form";

    }
}









