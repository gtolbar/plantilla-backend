package com.project.backend.infraestructure.configuration;

import com.project.backend.domain.api.IPersonaServicePort;
import com.project.backend.domain.spi.IPersonaPersistenePort;
import com.project.backend.domain.usecase.PersonaUseCase;
import com.project.backend.infraestructure.output.jpa.adapter.PersonaJpaAdapter;
import com.project.backend.infraestructure.output.jpa.mapper.PersonaEntityMapper;
import com.project.backend.infraestructure.output.jpa.repository.IPersonaRespository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final IPersonaRespository personaRespository;
    private final PersonaEntityMapper personaEntityMapper;

    public BeanConfiguration(IPersonaRespository personaRespository, PersonaEntityMapper personaEntityMapper) {
        this.personaRespository = personaRespository;
        this.personaEntityMapper = personaEntityMapper;
    }

    @Bean
    public IPersonaPersistenePort personaPersistenePort(){
        return new PersonaJpaAdapter(personaRespository,personaEntityMapper);
    }

    @Bean
    public IPersonaServicePort personaServicePort(){
        return new PersonaUseCase(personaPersistenePort());
    }

}
