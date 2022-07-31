
package com.portfolioap.ap.controller;

import com.portfolioap.ap.model.Persona;
import com.portfolioap.ap.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    
    @Autowired
    PersonaService personaService;
     
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Persona> getPersona(@PathVariable("id") Long id){
        Persona persona = personaService.getPersona(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    //@PreAuthorize("HasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Persona> editPersona(@PathVariable("id") Long id, @RequestBody Persona persona){
        Persona personaUpdate = personaService.editPersona(persona, id);
        return new ResponseEntity<>(personaUpdate, HttpStatus.OK);
    }
    
//    @DeleteMapping
//    public ResponseEntity
    
}
