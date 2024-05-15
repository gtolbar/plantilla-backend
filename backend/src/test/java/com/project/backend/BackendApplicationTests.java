package com.project.backend;

import com.project.backend.application.dto.PersonaResponse;
import com.project.backend.application.handler.IPersonaHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DataJpaTest
class BackendApplicationTests {


	private final IPersonaHandler personaHandler;

    BackendApplicationTests(IPersonaHandler personaHandler) {
        this.personaHandler = personaHandler;
    }


    @Test
	void contextLoads() {
		PersonaResponse personaResp = personaHandler.getModelFrom(2L);
		assert personaResp.getCedula().equals("1075399999");
	}

}
