package com.angel.proyectSpring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientDTO {


    private String nombre;
    private String alias;
    private Integer edad;
    private Long id;



}


