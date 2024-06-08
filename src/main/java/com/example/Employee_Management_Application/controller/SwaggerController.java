package com.example.Employee_Management_Application.controller;

import com.example.Employee_Management_Application.entity.Employee;
import com.example.Employee_Management_Application.repository.EmployeeRepository;
import com.example.Employee_Management_Application.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SwaggerController {

    @Autowired
    private EmployeeService service;


    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/byId/{id}")
    public Optional<Employee> getEmployeeById(@RequestParam Long id){
        return service.getEmployeeById(id);
    }

    @PostMapping("/new")
    public Employee createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }

//    @PutMapping("/update/{id}")
//    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee){
//
//        //get the id
//        Optional<Employee> employeeById = service.getEmployeeById(id);
//        Employee existEmployee = employeeById.get();
//        BeanUtils.copyProperties (updatedEmployee, existEmployee);
//        service. updateEmployee(existEmployee);
//        return updatedEmployee;
//
//    }

    @PutMapping("/update/{id}")
    public Employee updateById(@PathVariable Long id,@RequestBody Employee employee){
        return service.updateByIdEmployee(id,employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@RequestParam Long id){
        service.deleteEmployeeById(id);
    }
}
