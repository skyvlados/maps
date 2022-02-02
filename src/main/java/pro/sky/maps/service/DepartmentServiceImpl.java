package pro.sky.maps.service;

import org.springframework.stereotype.Service;
import pro.sky.maps.data.Employee;
import pro.sky.maps.exception.EmployeeNotFoundException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalary(String department) {
        if (employeeService.findAllEmployee().isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employeeService.findAllEmployee().stream()
                .filter(e->e.getDepartment().equals(department))
                .max(Comparator.comparing(e->e.getSalary()))
                .orElseThrow();
    }

    @Override
    public Employee findMinSalary(String department) {
        if (employeeService.findAllEmployee().isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employeeService.findAllEmployee().stream()
                    .filter(e -> e.getDepartment().equals(department))
                    .min(Comparator.comparing(e -> e.getSalary()))
                    .orElseThrow();
    }

    @Override
    public List<Employee> findAllEmployeeDepartment() {
        return employeeService.findAllEmployee().stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getFirstName)
                        .thenComparing(Employee::getLastName))
                .collect(Collectors.toList());
    }
    @Override
    public List<Employee> findAllEmployeeDepartment(String department) {
        return employeeService.findAllEmployee().stream()
                .filter(e->e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }
}
