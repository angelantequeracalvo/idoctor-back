package com.angel.proyectSpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "DOCTOR")
@Table(name = "DOCTOR")
@Getter
@Setter
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "nombre is required")
    private String nombre;
    @Column
    @NotBlank (message = "apellidos is required")
    private String apellidos;
    @Column
   // @NotBlank
    private Integer edad;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
   // @JoinColumn(name = "doctor_id")
   private List<PatientEntity> patients = new ArrayList<>();


}

