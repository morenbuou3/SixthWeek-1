package com.xaut.Employee.repository.repositoryImpl;

import com.xaut.Employee.Data.Cache;
import com.xaut.Employee.entity.Employee;
import com.xaut.Employee.repository.EmployeeRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

    @Override
    public List<Employee> getEmployees() {
        return Cache.getCache();
    }
}
