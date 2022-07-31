package com.portfolioap.ap.controller;

import com.portfolioap.ap.model.Experiencia;
import com.portfolioap.ap.services.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
//@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    @Autowired
    ExperienciaService expService;

    //Traer una educacion (no lo vamos a usar)
    @GetMapping("/id/{id}")
    public ResponseEntity<Experiencia> getExperiencia(@PathVariable("id") Long idExperiencia) {
        Experiencia experiencia = expService.getExperiencia(idExperiencia);
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }

    //trae TODAS las experiencias
    @GetMapping("/listar")
    public ResponseEntity<List<Experiencia>> listExperiencia() {
        List<Experiencia> expLista = expService.listExperiencia();
        return new ResponseEntity<>(expLista, HttpStatus.OK);
    }

    //Editar experiencia
    //@PreAuthorize("HasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Experiencia> editExperiencia(@PathVariable("id") Long idExperiencia, 
            @RequestBody Experiencia experiencia) {
        Experiencia expUpdate = expService.editExperiencia(experiencia, idExperiencia);
        return new ResponseEntity<>(expUpdate, HttpStatus.OK);
    }

    //agregar experiencia
    //@PreAuthorize("HasRole('ROLE_ADMIN')")
    @PostMapping("/agregar")
    public ResponseEntity<Experiencia> addExperiencia(@RequestBody Experiencia experiencia) {
        Experiencia nuevaExperiencia = expService.addExperiencia(experiencia);
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);

    }

    //borrar experiencia
    //@PreAuthorize("HasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable("id") Long idExperiencia) {
        expService.deleteExperiencia(idExperiencia);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
