package pro.sky.maps.service;

import org.springframework.stereotype.Service;
import pro.sky.maps.data.Employee;

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
    public Optional<Employee> findMaxSalary(String department) {
        return employeeService.getEmployees().stream()
                .filter(e->e.getDepartment().equals(department))
                .max(Comparator.comparing(e->e.getSalary()));
    }

    @Override
    public Optional<Employee> findMinSalary(String department) {

        return employeeService.getEmployees().stream()
                .filter(e->e.getDepartment().equals(department))
                .min(Comparator.comparing(e->e.getSalary()));
    }

    @Override
    public List<Employee> findAllEmployeeDepartment() {
        return employeeService.getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getFirstName)
                        .thenComparing(Employee::getLastName))
                .collect(Collectors.toList());
    }
    @Override
    public List<Employee> findAllEmployeeDepartment(String department) {
        return employeeService.getEmployees().stream()
                .filter(e->e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }
}
