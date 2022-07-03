
package com.portfolioap.ap.controller;

import com.portfolioap.ap.model.Educacion;
import com.portfolioap.ap.services.EducacionService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    private final EducacionService eduService;
    
    public EducacionController(EducacionService eduService){
        this.eduService = eduService;
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Educacion> getEducacion(@PathVariable("id") String id){
        Educacion educacion = eduService.getEducacion(id);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
    
    @GetMapping("listar")
    public ResponseEntity<List> listEducacion(@RequestBody List<Educacion> lista){
    
    List<Educacion> eduLista = eduService.listEducacion();
    
    return new ResponseEntity<>(eduLista, HttpStatus.OK);
}
    
    @PutMapping("/update")
    public ResponseEntity<Educacion> editEducacion(@RequestBody Educacion educacion){
        Educacion eduUpdate = eduService.editEducacion(educacion);
        return new ResponseEntity<>(eduUpdate, HttpStatus.OK);
    }
    
    
}
