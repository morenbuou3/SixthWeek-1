package com.xaut.Employee.controller;

import com.xaut.Employee.entity.Employee;
import com.xaut.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createEmployees(@RequestBody Employee e) {
        employeeService.addEmployees(e);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateEmployees(@RequestBody Employee e) {
        employeeService.updateEmployees(e);
    }
}
