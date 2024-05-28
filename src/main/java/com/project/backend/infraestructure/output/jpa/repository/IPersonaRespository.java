package com.project.backend.infraestructure.output.jpa.repository;

import com.project.backend.infraestructure.output.jpa.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonaRespository extends JpaRepository<PersonaEntity,Long> {

    //Optional<PersonaEntity> findByNumber(Long id); // opcional si esta en base de datos sin sacar null

}
