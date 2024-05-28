package com.project.backend.infraestructure.input.rest;

import com.project.backend.application.dto.PersonaRequest;
import com.project.backend.application.dto.PersonaResponse;
import com.project.backend.application.handler.IPersonaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@Tag(name = "API Personas", description = "Operaciones de ejemplo para proyecto backend plantilla")
public class PersonaRestController {

    private final IPersonaHandler personaHandler;

    public PersonaRestController(IPersonaHandler personaHandler) {
        this.personaHandler = personaHandler;
    }

    @PostMapping("/")
    @Operation(summary = "Guardar persona", description = "guarda persona en la BD")
    public ResponseEntity<Void> savePersonaIn(@RequestBody PersonaRequest personaRequest){
        personaHandler.saveModelIn(personaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    @Operation(summary = "Obtener", description = "Obtiene todas las personas de la BD")
    public ResponseEntity<List<PersonaResponse>> getAllPersonaFrom(){
        return ResponseEntity.ok(personaHandler.getAllModelFrom());
    }

    @GetMapping("/{number}")
    @Operation(summary = "Obtener por id", description = "Obtiene una las personas de la BD por id")
    public ResponseEntity<PersonaResponse> getPersonaFrom(@PathVariable(name = "number") Long id){
        return ResponseEntity.ok(personaHandler.getModelFrom(id));
    }

    @PutMapping("/")
    @Operation(summary = "Actualizar persona", description = "Actualiza una persona en la BD")
    public ResponseEntity<Void> updatePersonaIn(@RequestBody PersonaRequest personaRequest){
        personaHandler.updateModelIn(personaRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{number}")
    @Operation(summary = "Eliminar persona", description = "Elimina una persona en la BD por id")
    public ResponseEntity<Void> deletePersonasIn(@PathVariable(name = "number") Long id){
        personaHandler.deleteModelFrom(id);
        return ResponseEntity.ok().build();
    }

}
