package pro.sky.maps.service;

import org.springframework.stereotype.Service;
import pro.sky.maps.data.Employee;
import pro.sky.maps.exception.EmployeeNotFoundException;
import pro.sky.maps.exception.EmployeeStorageOverflowException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
        Map<Employee, Employee> employeeMap=new HashMap<>();

    public Employee addEmployee(String firstName, String lastName) {
        validateData(firstName, lastName);
        Employee newEmployee=new Employee(firstName,lastName);
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

    public Employee removeEmployees(String firstName, String lastName){
        Employee employeeRemove=new Employee(firstName, lastName);
        if (employeeMap.containsKey(employeeRemove)) {
            employeeMap.remove(employeeRemove);
            return employeeRemove;
        }
            throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName){
        Employee employeeFind=new Employee(firstName, lastName);
        validateData(firstName, lastName);
        if (employeeMap.containsKey(employeeFind)) {
            return employeeFind;
        }
        throw new EmployeeNotFoundException();
        }

    public List<Employee> showAllEmployee() {
        return new ArrayList<>(Collections.unmodifiableCollection(employeeMap.values()));
    }
}
