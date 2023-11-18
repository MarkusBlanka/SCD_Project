package com.SCD.proiectSCD.Controllers;

import com.SCD.proiectSCD.Models.Employee;
import com.SCD.proiectSCD.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/createEmployee")
    public void createEmployee(@RequestBody Employee e){
        employeeService.createEmployee(e);
    }

    @PostMapping("updateDepartment")
    public void updateEmail(int id, String email){
        employeeService.updateEmail(id,email);
    }

    @PostMapping("/deleteEmployee")
    public  void deleteEmployee(Employee e){
        employeeService.deleteEmployee(e);
    }

}
