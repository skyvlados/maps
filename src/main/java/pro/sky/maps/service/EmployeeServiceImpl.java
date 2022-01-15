package pro.sky.maps.service;

import org.springframework.stereotype.Service;
import pro.sky.maps.data.Employee;
import pro.sky.maps.exception.EmployeeNotFoundException;
import pro.sky.maps.exception.EmployeeStorageOverflowException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<Employee>();

    public Employee addEmployee(String firstName, String lastName) {
        validateData(firstName, lastName);
        Employee newEmployees=new Employee(firstName,lastName);
        employees.add(newEmployees);
        return newEmployees;
    }

    private void validateData(String firstName, String lastName) {
        if (firstName == "" && lastName == "") {
            throw new EmployeeStorageOverflowException();
        }
    }

    public Employee removeEmployees(String firstName, String lastName){
        Employee employeeRemove=new Employee(firstName, lastName);
        if (employees.contains(employeeRemove)) {
            employees.remove(employeeRemove);
            return employeeRemove;
        }
            throw new EmployeeNotFoundException();
    }

    public Employee employee(String firstName, String lastName){
        Employee employeeFind=new Employee(firstName, lastName);
        validateData(firstName, lastName);
        if (employees.contains(employeeFind)) {
            return employeeFind;
        }
        throw new EmployeeNotFoundException();
        }

    public List<Employee> allEmployee() {
        return new ArrayList<>(employees);
    }
}
