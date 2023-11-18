package com.SCD.proiectSCD.Controllers;

import com.SCD.proiectSCD.Models.Department;
import com.SCD.proiectSCD.Services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    DepartmentService departmentService;


    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/delete")
    public void deleteFromTable(Department d) {
        departmentService.deleteFromTable(d);
    }

    @PostMapping("/update")
    public void updateDepartment(int id, String description){
        departmentService.updateDepartment(id,description);
    }

    @PostMapping("/createDepartment")
    public void createDepartment(@RequestBody Department d){
        departmentService.createDepartment(d);
    }


}
