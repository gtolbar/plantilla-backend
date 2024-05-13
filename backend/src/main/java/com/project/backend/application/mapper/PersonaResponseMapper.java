package com.project.backend.application.mapper;


import com.project.backend.application.dto.PersonaRequest;
import com.project.backend.application.dto.PersonaResponse;
import com.project.backend.domain.model.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface PersonaResponseMapper {

    @Mapping(target = "nombreCompleto", expression = "java(persona.getNombre() + ' ' + persona.getApellido())")
    PersonaResponse toResponse(Persona persona);

    /*
    @Named("concatenateNames")
    static String concatenateNames(Persona persona) {
        return persona.getNombre() + " " + persona.getApellido();
    }*/

    List<PersonaResponse> toResponseList(List<Persona> personas);

}
