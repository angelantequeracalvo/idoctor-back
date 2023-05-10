package com.angel.proyectSpring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientDTO {


    private String name;
    private String surname;
    private Integer age;
    private Long id;
    private String dni;



}


