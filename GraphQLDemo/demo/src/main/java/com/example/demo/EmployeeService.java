package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        // Preload some data
        employees.add(new Employee(1L, "John", "Doe", "john.doe@example.com"));
        employees.add(new Employee(2L, "Jane", "Doe", "jane.doe@example.com"));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employees.stream().filter(emp -> emp.getId().equals(id)).findFirst();
    }

    public Employee addEmployee(String firstName, String lastName, String email) {
        Employee employee = new Employee((long) (employees.size() + 1), firstName, lastName, email);
        employees.add(employee);
        return employee;
    }
}

