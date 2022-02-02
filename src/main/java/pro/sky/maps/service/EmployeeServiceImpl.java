package pro.sky.maps.service;

import org.springframework.stereotype.Service;
import pro.sky.maps.data.Employee;
import pro.sky.maps.exception.EmployeeNotFoundException;
import pro.sky.maps.exception.EmployeeStorageOverflowException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<Employee, Employee> employeeMap=new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName, String department,int salary) {
        validateData(firstName, lastName);
        Employee newEmployee=new Employee(firstName,lastName, department, salary);
        if (employeeMap.containsKey(newEmployee)) {
            throw new EmployeeStorageOverflowException();
        }
        employeeMap.put(newEmployee,newEmployee);
        return newEmployee;
    }

    private void validateData(String firstName, String lastName) {
        if (firstName == "" && lastName == "") {
            throw new EmployeeStorageOverflowException();
        }
    }
    @Override
    public Employee removeEmployees(String firstName, String lastName, String department,int salary){
        Employee employeeRemove=new Employee(firstName, lastName,department,salary);
        if (employeeMap.containsKey(employeeRemove)) {
            return employeeMap.remove(employeeRemove);
        }
            throw new EmployeeNotFoundException();
    }
    @Override
    public Employee findEmployee(String firstName, String lastName, String department,int salary){
        Employee employeeFind=new Employee(firstName, lastName,department,salary);
        validateData(firstName, lastName);
        if (employeeMap.containsKey(employeeFind)) {
            return employeeFind;
        }
        throw new EmployeeNotFoundException();
        }

    @Override
    public Set<Employee> findAllEmployee() {
        return new HashSet<>(employeeMap.values()) ;
    }

}
