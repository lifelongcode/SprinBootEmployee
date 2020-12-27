package com.abrahamspw.springhwone.dao;

import com.abrahamspw.springhwone.model.Employee;
import java.util.List;
import java.util.ArrayList;

public class EmployeeDAOService {


    private static List<Employee> employee = new ArrayList<>();

    //Retrieve all Users
    public Iterable<Employee> findAll() {
        return employee;
    }


    //Get a Particular User
    public Employee findOne(int id) {
        for (Employee emp : employee) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
}
