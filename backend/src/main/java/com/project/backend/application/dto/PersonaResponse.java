package com.project.backend.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaResponse {
    private Long id;
    private String nombreCompleto;
    private String cedula;
}
