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
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.findEmployee(firstName,lastName);
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        return employeeServiceImpl.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        return employeeServiceImpl.removeEmployees(firstName, lastName);
    }

    @GetMapping("/all")
    public List<Employee> showAllEmployee() {
        return employeeServiceImpl.showAllEmployee();
    }

}
