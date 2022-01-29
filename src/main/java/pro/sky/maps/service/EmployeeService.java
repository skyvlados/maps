package pro.sky.maps.service;

import pro.sky.maps.data.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface EmployeeService {
    public Employee addEmployee(String firstName, String lastName,String department, int salary);
    public Employee removeEmployees(String firstName, String lastName,String department, int salary);
    public Employee findEmployee(String firstName, String lastName,String department, int salary);
    public List<Employee> findAllEmployee();
    public Set<Employee> getEmployees();
}
