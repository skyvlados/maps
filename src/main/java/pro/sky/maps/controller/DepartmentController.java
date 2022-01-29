package pro.sky.maps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.maps.data.Employee;
import pro.sky.maps.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/max-salary")
    public Employee findMaxSalary(@RequestParam String department) {
        return departmentService.findMaxSalary(department).orElseThrow();
    }

    @GetMapping("/min-salary")
    public Employee findMinSalary(@RequestParam String department) {
        return departmentService.findMinSalary(department).orElseThrow();
    }

    @GetMapping("/all")
    public List<Employee> findAllEmployeeDepartment(String department) {
        if (department == null) {
            return departmentService.findAllEmployeeDepartment();
        }
        return departmentService.findAllEmployeeDepartment(department);
    }

}
