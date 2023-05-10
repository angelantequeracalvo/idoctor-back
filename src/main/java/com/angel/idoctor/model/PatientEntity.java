package com.angel.idoctor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;


@Entity(name = "PATIENT")
@Getter
@Setter
public class PatientEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank(message = "nombre is required")
    private String name;
    @Column
    @NotBlank(message = "nombre is required")
    private String surname;
    @Column
    private Integer age;
    @Column
    private String dni;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AppointmentEntity> appointments;




}


