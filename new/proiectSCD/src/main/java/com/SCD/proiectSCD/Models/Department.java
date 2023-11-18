package com.SCD.proiectSCD.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue
    int id;
    @Column
    String description;
    @ManyToOne
    Department parent;
}
