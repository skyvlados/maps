package pro.sky.maps.service;

import pro.sky.maps.data.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, String department, int salary);
    Employee removeEmployees(String firstName, String lastName, String department, int salary);
    Employee findEmployee(String firstName, String lastName, String department, int salary);
    Set<Employee> findAllEmployee();
}
