package com.project.backend.domain.usecase;

import com.project.backend.domain.api.IPersonaServicePort;
import com.project.backend.domain.model.Persona;
import com.project.backend.domain.spi.IPersonaPersistenePort;

import java.util.List;

public class PersonaUseCase implements IPersonaServicePort {

    private final IPersonaPersistenePort personaPersistenePort;

    public PersonaUseCase(IPersonaPersistenePort personaPersistenePort) {
        this.personaPersistenePort = personaPersistenePort;
    }

    @Override
    public void saveModel(Persona persona) {
        personaPersistenePort.saveModel(persona);
    }

    @Override
    public List<Persona> getAllModel() {
        return personaPersistenePort.getAllModel();
    }

    @Override
    public Persona getModel(Long id) {
        // ################ La logica de negocio debe ir en los casos de uso ###############
        Persona persona = personaPersistenePort.getModel(id);
        persona.setNombre(persona.getNombre().toUpperCase());
        persona.setApellido(persona.getApellido().toUpperCase());
        return persona;
    }

    @Override
    public void updateModel(Persona persona) {
        personaPersistenePort.updateModel(persona);
    }

    @Override
    public void deleteModel(Long id) {
        personaPersistenePort.deleteModel(id);
    }

}
