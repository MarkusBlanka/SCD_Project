package com.SCD.proiectSCD.Services;

import com.SCD.proiectSCD.Models.Department;
import com.SCD.proiectSCD.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();

    }

    public void createDepartment(Department d) {
        departmentRepository.save(d);

    }

    public void deleteFromTable(Department d) {
        departmentRepository.delete(d);
    }

    public void updateDepartment(int id, String description) {
        Optional<Department> d = departmentRepository.findById(id);
        if (d.isPresent()) {
            Department d1 = d.get();
            d1.setDescription(description);
            departmentRepository.save(d1);
        } else {
            throw new RuntimeException("Department not found");
        }
    }

}
