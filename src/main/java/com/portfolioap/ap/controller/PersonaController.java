
package com.portfolioap.ap.controller;

import com.portfolioap.ap.model.Persona;
import com.portfolioap.ap.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/persona")
//@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    private final PersonaService personaService;
    
    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }
    
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Persona> getPersona(@PathVariable("id") Long id){
        Persona persona = personaService.getPersona(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    

    @PutMapping("/update")
    public ResponseEntity<Persona> editPersona(@RequestBody Persona persona){
        Persona personaUpdate = personaService.editPersona(persona);
        return new ResponseEntity<>(personaUpdate, HttpStatus.OK);
    }
    
//    @DeleteMapping
//    public ResponseEntity
    
}
