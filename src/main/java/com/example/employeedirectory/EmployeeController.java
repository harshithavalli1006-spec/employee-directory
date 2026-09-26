package com.example.employeedirectory;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeController() {
        employees.add(new Employee(1L, "Harshitha", "Software Engineer"));
        employees.add(new Employee(2L, "Rahul", "Data Analyst"));
        employees.add(new Employee(3L, "Priya", "ML Engineer"));
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employees;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId((long) (employees.size() + 1));
        employees.add(employee);
        return employee;
    }
}
