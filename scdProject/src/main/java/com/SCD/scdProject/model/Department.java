package com.SCD.scdProject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "departments")
@Getter
@Setter

public class Department {
    @Id
    private String id;
    private String departmentName;
    private String description;



    public Department(String departmentName, String description) {
        this.departmentName = departmentName;
        this.description = description;
    }


}
