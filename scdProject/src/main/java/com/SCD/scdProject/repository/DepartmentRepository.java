package com.SCD.scdProject.repository;

import com.SCD.scdProject.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, String> {

    List<Department> findByDepartmentName(String departmentName);
}
