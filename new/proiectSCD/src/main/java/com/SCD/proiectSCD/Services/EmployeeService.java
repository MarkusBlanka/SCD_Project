package com.SCD.proiectSCD.Services;

import com.SCD.proiectSCD.Models.Employee;
import com.SCD.proiectSCD.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void createEmployee(Employee e){
        employeeRepository.save(e);
    }

    public void updateEmail(int id, String email){
        Optional<Employee> e = employeeRepository.findById(id);
        if(e.isPresent()){
            Employee e1 = e.get();
            e1.setEmail(email);
            employeeRepository.save(e1);
        } else {
            throw new RuntimeException("Idk :/");
        }


    }

    public void deleteEmployee(Employee e){
        employeeRepository.delete(e);
    }
}
