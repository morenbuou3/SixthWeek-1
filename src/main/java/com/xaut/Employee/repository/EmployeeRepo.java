package com.xaut.Employee.repository;

import com.xaut.Employee.entity.Employee;

import java.util.List;

public interface EmployeeRepo {
    List<Employee> getEmployees();

    void addEmployees(Employee e);

    void updateEmployees(Employee e);
}
