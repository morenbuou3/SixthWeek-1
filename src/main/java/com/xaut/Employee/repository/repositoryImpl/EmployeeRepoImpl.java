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

    @Override
    public void addEmployees(Employee e) {
        if (Cache.getCache().stream().anyMatch(n -> n.getId() == e.getId())) {
            return;
        }
        Cache.getCache().add(e);
    }

    @Override
    public void updateEmployees(Employee e) {
        if (Cache.getCache().stream().anyMatch(n -> n.getId() == e.getId())) {
            Cache.getCache().removeIf(n -> n.getId() == e.getId());
            Cache.getCache().add(e);
        }
    }
}
