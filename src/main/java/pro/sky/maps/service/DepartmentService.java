package pro.sky.maps.service;

import pro.sky.maps.data.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Optional<Employee> findMaxSalary(String department);
    public Optional<Employee> findMinSalary(String department);

    List<Employee> findAllEmployeeDepartment();

    public List<Employee> findAllEmployeeDepartment(String department);
}
