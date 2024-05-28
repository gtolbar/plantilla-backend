package com.project.backend.infraestructure.output.jpa.mapper;

import com.project.backend.domain.model.Persona;
import com.project.backend.infraestructure.output.jpa.entity.PersonaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface PersonaEntityMapper {

    PersonaEntity toEntity(Persona persona);
    Persona toPersona(PersonaEntity personaEntity);
    List<Persona> toPersonaList(List<PersonaEntity> listPersonaEntity);

}
