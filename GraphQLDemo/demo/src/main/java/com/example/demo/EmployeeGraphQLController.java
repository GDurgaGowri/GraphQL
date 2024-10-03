package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@Component
public class EmployeeGraphQLController {

    @Autowired
    public EmployeeService employeeService;

    // Query to get all employees
    @QueryMapping
    public List<Employee> employees() {
        return employeeService.getAllEmployees();
    }

    // Query to get a specific employee by ID
    @QueryMapping
    public Employee employee(@Argument Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.orElse(null);
    }

}

