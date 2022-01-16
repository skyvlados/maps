package pro.sky.maps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.maps.data.Employee;
import pro.sky.maps.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {

        this.employeeServiceImpl = employeeServiceImpl;
    }
    @GetMapping("/find")
    public Employee employee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.employee(firstName,lastName);
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        employeeServiceImpl.addEmployee(firstName, lastName);
        return "Сотрудник "+firstName+" "+lastName+" успешно создан.";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        employeeServiceImpl.removeEmployees(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " удален";
    }

    @GetMapping("/all")
    public Map<Integer, Employee> allEmployee() {
        return employeeServiceImpl.allEmployee();
    }

}
