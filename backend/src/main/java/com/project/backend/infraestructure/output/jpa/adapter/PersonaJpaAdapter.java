package com.project.backend.infraestructure.output.jpa.adapter;

import com.project.backend.domain.model.Persona;
import com.project.backend.domain.spi.IPersonaPersistenePort;
import com.project.backend.infraestructure.exception.PersonaAlreadyExistsException;
import com.project.backend.infraestructure.exception.PersonaNotFoundException;
import com.project.backend.infraestructure.output.jpa.entity.PersonaEntity;
import com.project.backend.infraestructure.output.jpa.mapper.PersonaEntityMapper;
import com.project.backend.infraestructure.output.jpa.repository.IPersonaRespository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PersonaJpaAdapter implements IPersonaPersistenePort {

    private final IPersonaRespository personaRespository;
    private final PersonaEntityMapper personaEntityMapper;


    @Override
    public void saveModel(Persona model) {
        if (personaRespository.findById(model.getId()).isPresent()){
            throw new PersonaAlreadyExistsException();
        }
        personaRespository.save(personaEntityMapper.toEntity(model));
    }

    @Override
    public List<Persona> getAllModel() {
        List<PersonaEntity> listPersona = personaRespository.findAll();
        if (listPersona.isEmpty()){
            throw new PersonaNotFoundException();
        }
        return personaEntityMapper.toPersonaList(listPersona);
    }

    @Override
    public Persona getModel(Long id) {
        return personaEntityMapper.toPersona(personaRespository.findById(id).orElseThrow(PersonaNotFoundException::new));
    }

    @Override
    public void updateModel(Persona model) {
        personaRespository.save(personaEntityMapper.toEntity(model));
    }

    @Override
    public void deleteModel(Long id) {
        personaRespository.deleteById(id);
    }
}
