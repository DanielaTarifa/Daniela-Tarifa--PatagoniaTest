package com.tutorial.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    private Double grade;//amount-calificacion
    private String subject;//type-materia
    private int clientId;
}
