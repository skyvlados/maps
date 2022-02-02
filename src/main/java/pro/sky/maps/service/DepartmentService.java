package pro.sky.maps.service;

import pro.sky.maps.data.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Employee findMaxSalary(String department);
    Employee findMinSalary(String department);

    List<Employee> findAllEmployeeDepartment();

    List<Employee> findAllEmployeeDepartment(String department);
}
