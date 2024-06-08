package com.example.Employee_Management_Application.controller;

import com.example.Employee_Management_Application.entity.Employee;
import com.example.Employee_Management_Application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    //To Display Employees-Main page
    @GetMapping("/")
    public String employeeList(Model model){
        model.addAttribute("EmployeeList",service.getAllEmployees());
        return "index";
    }

    //Getting Employee save form
    @GetMapping("/addUsers")
    public String showCreateEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "newEmployee";
    }

    //post method to save the employee
    @PostMapping("/saveEmployee")
    public String createNewEmployee(@ModelAttribute("employee") Employee employee){
        service.createEmployee(employee);
        return "redirect:/";
    }


    //Display single employee data
    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable(value = "id") Long id, Model model) {
        Optional<Employee> optionalEmployee = service.getEmployeeById(id);
        Employee employee = optionalEmployee.orElse(null);
        model.addAttribute("employee", employee);
        return "viewEmployee";
    }

    //Getting the update employee form
    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable(value ="id") Long id ,Model model){
        Optional<Employee> optionalEmployee = service.getEmployeeById(id);
        Employee employee = optionalEmployee.orElse(null);
        model.addAttribute("employeeUpdate",employee);
        return "updateEmployee";
    }

    //updating the existing employee using id
    @RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.PUT})
    public String UpdateEmployee(@ModelAttribute("employeeUpdate") Employee updatedEmployee){
        service.updateEmployee(updatedEmployee);
        return "redirect:/";
    }

    //Delete using hidden filter and by id
    @RequestMapping(value = "/deleteEmployee/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteEmployee(@PathVariable(value = "id") Long id ){
        service.deleteEmployeeById(id);
        return "redirect:/";
    }

}
