package pro.sky.maps.service;

import pro.sky.maps.data.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public Employee addEmployee(String firstName, String lastName);
    public Employee removeEmployees(String firstName, String lastName);
    public Employee findEmployee(String firstName, String lastName);
    public List<Employee> showAllEmployee();
}
