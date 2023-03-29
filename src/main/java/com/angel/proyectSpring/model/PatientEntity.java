package com.angel.proyectSpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "PATIENT")
@Table(name = "PATIENT")
@Getter
@Setter
public class PatientEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private Integer edad;
    @Column
    private String dni;



}


