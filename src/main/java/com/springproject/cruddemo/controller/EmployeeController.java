package com.springproject.cruddemo.controller;

import com.springproject.cruddemo.entity.Employee;
import com.springproject.cruddemo.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<Employee> employees = this.employeeService.findAllEmployee();
        // add to the spring model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        // create model attribute to bind form data
        Employee newEmployee = new Employee(new ObjectId());

        model.addAttribute("employee", newEmployee);

        return "employees/add-employee-form";

    }
//
//    @GetMapping("/showFormForUpdate")
//    public String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model model) {
//        // get the employee from the service
//        Employee employee = this.employeeService.findById(employeeId);
//        // set employee in the model to prepopulate the form
//        model.addAttribute("employee", employee);
//        // send over to our form
//        return "employees/add-employee-form";
//    }
//
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") ObjectId employeeId) {
        // delete the employee
        this.employeeService.deleteEmployee(employeeId);
        // redirect to the /employees/list
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save the employee
        this.employeeService.saveEmployee(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
}









