package com.SCD.proiectSCD.Repositories;

import com.SCD.proiectSCD.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
