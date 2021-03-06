package com.xaut.Employee.service;

import com.xaut.Employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    void addEmployees(Employee e);

    void updateEmployees(Employee e);

    void deleteEmployees(Employee e);
}
