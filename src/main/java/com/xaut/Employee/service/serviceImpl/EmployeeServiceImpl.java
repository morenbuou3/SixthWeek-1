package com.xaut.Employee.service.serviceImpl;

import com.xaut.Employee.entity.Employee;
import com.xaut.Employee.repository.EmployeeRepo;
import com.xaut.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.getEmployees();
    }

    @Override
    public void addEmployees(Employee e) {
        employeeRepo.addEmployees(e);
    }

    @Override
    public void updateEmployees(Employee e) {
        employeeRepo.updateEmployees(e);
    }

    @Override
    public void deleteEmployees(Employee e) {
        employeeRepo.deleteEmployees(e);
    }
}
