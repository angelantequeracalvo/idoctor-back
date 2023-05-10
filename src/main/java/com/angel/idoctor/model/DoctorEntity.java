package com.angel.idoctor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Entity(name = "DOCTOR")
@Getter
@Setter
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "nombre is required")
    private String name;
    @Column
    @NotBlank (message = "apellidos is required")
    private String surname;
    @Column
    private Integer age;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AppointmentEntity> appointments;

  //  @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
   // @JoinColumn(name = "doctor_id")
 //  private List<PatientEntity> patients = new ArrayList<>();


}

