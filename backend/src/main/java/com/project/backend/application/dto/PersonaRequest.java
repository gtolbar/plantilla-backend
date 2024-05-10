package com.project.backend.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaRequest {

    private Long id;
    private String nombre;
    private String apellido;
    private String cedula;

}
