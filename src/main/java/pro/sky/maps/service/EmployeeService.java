package pro.sky.maps.service;

import pro.sky.maps.data.Employee;

import java.util.*;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, String department, int salary);
    Employee removeEmployees(String firstName, String lastName, String department, int salary);
    Employee findEmployee(String firstName, String lastName, String department, int salary);
    Collection<Employee> findAllEmployee();
}
