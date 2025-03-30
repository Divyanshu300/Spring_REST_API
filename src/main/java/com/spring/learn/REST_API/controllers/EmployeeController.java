package com.spring.learn.REST_API.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.learn.REST_API.configurrations.AppConfig;
import com.spring.learn.REST_API.dto.EmployeeDTO;
import com.spring.learn.REST_API.repositories.EmployeeRepository;
import com.spring.learn.REST_API.services.EmployeeService;

@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        System.out.println(id);
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("employees")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("employees/{id}")
    public boolean deleteEmployeeBYId(@PathVariable Long id) {
        return employeeService.deleteEmployeeById(id);
    }
}
