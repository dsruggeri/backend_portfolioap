package com.portfolioap.ap.controller;

import com.portfolioap.ap.model.Educacion;
import com.portfolioap.ap.model.Experiencia;
import com.portfolioap.ap.services.ExperienciaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    private final ExperienciaService expService;

    public ExperienciaController(ExperienciaService expService) {
        this.expService = expService;
    }

    //Traer una educacion (no lo vamos a usar)
    @GetMapping("/id/{id}")
    public ResponseEntity<Experiencia> getExperiencia(@PathVariable("id") String id) {
        Experiencia experiencia = expService.getExperiencia(id);
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }

    //trae TODAS las experiencias
    @GetMapping("/listar")
    public ResponseEntity<List<Experiencia>> listExperiencia(@RequestBody List<Experiencia> lista) {
        List<Experiencia> expLista = expService.listExperiencia();
        return new ResponseEntity<>(expLista, HttpStatus.OK);
    }

    //Editar experiencia
    @PutMapping("/update")
    public ResponseEntity<Experiencia> editExperiencia(@RequestBody Experiencia experiencia) {
        Experiencia expUpdate = expService.editExperiencia(experiencia);
        return new ResponseEntity<>(expUpdate, HttpStatus.OK);
    }

    //agregar experiencia
    @PostMapping("/agregar")
    public ResponseEntity<Experiencia> addExperiencia(@RequestBody Experiencia experiencia) {
        Experiencia nuevaExperiencia = expService.addExperiencia(experiencia);
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);

    }

    //borrar experiencia
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable String id) {
        expService.deleteExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
