package com.SCD.scdProject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter

@Document(collection = "employees")
public class Employee {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String position;

    private String department;

    public Employee(String firstName, String lastName, String position,String department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.department = department;

    }




}
