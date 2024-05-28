package com.project.backend.application.handler;

import com.project.backend.application.dto.PersonaRequest;
import com.project.backend.application.dto.PersonaResponse;
import com.project.backend.application.mapper.PersonaRequestMapper;
import com.project.backend.application.mapper.PersonaResponseMapper;
import com.project.backend.domain.api.IPersonaServicePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //ACID principios
public class PersonaHandler implements IPersonaHandler{

    private final IPersonaServicePort personaServicePort;
    private final PersonaRequestMapper personaRequestMapper;
    private final PersonaResponseMapper personaResponseMapper;

    public PersonaHandler(IPersonaServicePort personaServicePort, PersonaRequestMapper personaRequestMapper, PersonaResponseMapper personaResponseMapper) {
        this.personaServicePort = personaServicePort;
        this.personaRequestMapper = personaRequestMapper;
        this.personaResponseMapper = personaResponseMapper;
    }


    @Override
    public void saveModelIn(PersonaRequest personaRequest) {
        personaServicePort.saveModel(personaRequestMapper.toPersona(personaRequest));
    }

    @Override
    public List<PersonaResponse> getAllModelFrom() {
        return personaResponseMapper.toResponseList(personaServicePort.getAllModel());
    }

    @Override
    public PersonaResponse getModelFrom(Long id) {
        return personaResponseMapper.toResponse(personaServicePort.getModel(id));
    }

    @Override
    public void updateModelIn(PersonaRequest personaRequest) {
        personaServicePort.updateModel(personaRequestMapper.toPersona(personaRequest));
    }

    @Override
    public void deleteModelFrom(Long id) {
        personaServicePort.deleteModel(id);
    }
}
