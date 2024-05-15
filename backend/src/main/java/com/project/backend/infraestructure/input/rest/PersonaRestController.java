package com.project.backend.infraestructure.input.rest;

import com.project.backend.application.dto.PersonaRequest;
import com.project.backend.application.dto.PersonaResponse;
import com.project.backend.application.handler.IPersonaHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaRestController {

    private final IPersonaHandler personaHandler;

    public PersonaRestController(IPersonaHandler personaHandler) {
        this.personaHandler = personaHandler;
    }

    @PostMapping("/")
    public ResponseEntity<Void> savePersonaIn(@RequestBody PersonaRequest personaRequest){
        personaHandler.saveModelIn(personaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonaResponse>> getAllPersonaFrom(){
        return ResponseEntity.ok(personaHandler.getAllModelFrom());
    }

    @GetMapping("/{number}")
    public ResponseEntity<PersonaResponse> getPersonaFrom(@PathVariable(name = "number") Long id){
        return ResponseEntity.ok(personaHandler.getModelFrom(id));
    }

    @PutMapping("/")
    public ResponseEntity<Void> updatePersonaIn(@RequestBody PersonaRequest personaRequest){
        personaHandler.updateModelIn(personaRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deletePersonasIn(@PathVariable(name = "number") Long id){
        personaHandler.deleteModelFrom(id);
        return ResponseEntity.ok().build();
    }

}
