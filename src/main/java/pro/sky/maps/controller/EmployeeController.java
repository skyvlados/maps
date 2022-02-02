package pro.sky.maps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.maps.data.Employee;
import pro.sky.maps.service.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {

        this.employeeServiceImpl = employeeServiceImpl;
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                 @RequestParam String department,@RequestParam int salary) {
        return employeeServiceImpl.findEmployee(firstName,lastName,department,salary);
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,@RequestParam String lastName,
                                @RequestParam String department,@RequestParam int salary) {
        return employeeServiceImpl.addEmployee(firstName,lastName,department,salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,@RequestParam String lastName,
                                   @RequestParam String department,@RequestParam int salary) {
        return employeeServiceImpl.removeEmployees(firstName,lastName,department,salary);
    }

    @GetMapping("/all")
    public Collection<Employee> findAllEmployee() {
        return employeeServiceImpl.findAllEmployee();
    }

}
