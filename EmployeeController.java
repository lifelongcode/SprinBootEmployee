package com.abrahamspw.springhwone.controller;

import com.abrahamspw.springhwone.model.Employee;
import com.abrahamspw.springhwone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.validation.Valid;
import com.abrahamspw.springhwone.exception.ResourceNotFoundException;
import java.util.List;

@Controller

@RestController
@RequestMapping("/api/auth/")
public class EmployeeController {
// Just home page
    @GetMapping("/")
    public String showHomePage(){
       // System.out.println("This is my Employee Home Page");
        return "This is Just a Home Page.";
    }


    @Autowired
    private EmployeeRepository employeeRepository;


    @CrossOrigin
    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        Employee employee1 = employeeRepository.save(employee);
        return employee;
    }

    @CrossOrigin
    @GetMapping("/employee")
    public Page<Employee> listEmployees(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

    //Give me one employee, if I pass the id
    @CrossOrigin
    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable Long id){
        Employee employee = employeeRepository.getOne(id);
                return employee;
    }

    //After added there will be the time to delete the employee
    @CrossOrigin
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        return employeeRepository.findById(id)
                .map(employee -> {employeeRepository.delete(employee);
                return ResponseEntity.ok().build();})
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with the id " + id));
    }

}

