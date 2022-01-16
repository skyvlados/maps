package pro.sky.maps.service;

import pro.sky.maps.data.Employee;

import java.util.Map;

public interface EmployeeService {
    public Employee addEmployee(String firstName, String lastName);
    public Employee removeEmployees(String firstName, String lastName);
    public Employee employee(String firstName, String lastName);
    public Map<Integer, Employee> allEmployee();
}
