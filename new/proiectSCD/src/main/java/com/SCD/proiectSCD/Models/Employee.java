package com.SCD.proiectSCD.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Entity

public class Employee {

    @Id
    @GeneratedValue
    int id;
    @Column
    String name;
    @Column
    String email;
    @ManyToOne
    Department department;
    @ManyToOne
    Employee manager;
}
