package com.example.Employee_Management_Application.service;

import com.example.Employee_Management_Application.entity.Employee;
import com.example.Employee_Management_Application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    //All Employee details
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    //Employee by Id
    public Optional<Employee> getEmployeeById(long id){
        return repository.findById(id);
    }

    //Creating new employee
    public Employee createEmployee(Employee employee){
        return repository.save(employee);
    }


    //delete employee using id
    public void deleteEmployeeById(Long id){
        repository.deleteById(id);
    }

    //update Employee
    public void updateEmployee(Employee updatedEmployee ) {
        Optional<Employee> optionalEmployee = repository.findById(updatedEmployee.getId());
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setGender(updatedEmployee.getGender());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setEmpType(updatedEmployee.getEmpType());
            employee.setLocation(updatedEmployee.getLocation());
            repository.save(employee);
        }
        //return updatedEmployee;
    }

    //Update
    public Employee updateByIdEmployee(Long id,Employee updateEmployee){

            Optional<Employee> optionalEmployee = repository.findById(id);
            Employee employee = optionalEmployee.get();
            employee.setFirstName(updateEmployee.getFirstName());
            employee.setLastName(updateEmployee.getLastName());
            employee.setEmail(updateEmployee.getEmail());
            employee.setGender(updateEmployee.getGender());
            employee.setEmpType(updateEmployee.getEmpType());
            employee.setLocation(updateEmployee.getLocation());
            return repository.save(employee);
    }
}
