package pro.sky.maps.service;

import org.springframework.stereotype.Service;
import pro.sky.maps.data.Employee;
import pro.sky.maps.exception.EmployeeNotFoundException;
import pro.sky.maps.exception.EmployeeStorageOverflowException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
        Map<Integer, Employee> employeeMap=new HashMap<>();
        Integer nextId=0;

    private Integer getNextId() {
        Integer result=nextId;
        nextId=nextId+1;
        return result;
    }

    public Employee addEmployee(String firstName, String lastName) {
        validateData(firstName, lastName);
        if (employeeMap.containsValue(new Employee(firstName, lastName))) {
            throw new EmployeeStorageOverflowException();
        }
        Employee newEmployees=employeeMap.put(getNextId(),new Employee(firstName, lastName));
        return newEmployees;
    }

    private void validateData(String firstName, String lastName) {
        if (firstName == "" && lastName == "") {
            throw new EmployeeStorageOverflowException();
        }
    }

    public static <Integer, Employee> Integer getKeyByValue(Map<Integer, Employee> map, Employee value) {
        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Employee removeEmployees(String firstName, String lastName){
        Employee employeeRemove=new Employee(firstName, lastName);
        if (employeeMap.containsValue(employeeRemove)) {
            employeeMap.remove(getKeyByValue(employeeMap,employeeRemove));
            return employeeRemove;
        }
            throw new EmployeeNotFoundException();
    }

    public Employee employee(String firstName, String lastName){
        Employee employeeFind=new Employee(firstName, lastName);
        validateData(firstName, lastName);
        if (employeeMap.containsValue(employeeFind)) {
            return employeeFind;
        }
        throw new EmployeeNotFoundException();
        }

    public Map<Integer, Employee> allEmployee() {
        return new HashMap<>(employeeMap);
    }
}
