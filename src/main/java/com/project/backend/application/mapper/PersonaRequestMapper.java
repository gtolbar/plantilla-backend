package com.project.backend.application.mapper;

import com.project.backend.application.dto.PersonaRequest;
import com.project.backend.domain.model.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface PersonaRequestMapper {

    Persona toPersona(PersonaRequest personaRequest);

}
