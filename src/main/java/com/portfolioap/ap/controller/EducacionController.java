
package com.portfolioap.ap.controller;

import com.portfolioap.ap.model.Educacion;
import com.portfolioap.ap.services.EducacionService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    private final EducacionService eduService;
    
    public EducacionController(EducacionService eduService){
        this.eduService = eduService;
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Educacion> getEducacion(@PathVariable("id") Long idEducacion){
        Educacion educacion = eduService.getEducacion(idEducacion);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<Educacion>> listEducacion(){
    
    List<Educacion> eduLista = eduService.listEducacion();
    
    return new ResponseEntity<>(eduLista, HttpStatus.OK);
}
    
    
    @PutMapping("/update")
    public ResponseEntity<Educacion> editEducacion(@RequestBody Educacion educacion){
        Educacion eduUpdate = eduService.editEducacion(educacion);
        return new ResponseEntity<>(eduUpdate, HttpStatus.OK);
    }
    
   
    @PostMapping("/agregar")
    public ResponseEntity<Educacion> addEducacion(@RequestBody Educacion educacion){
        
        Educacion nuevaEducacion = eduService.addEducacion(educacion);
        return new ResponseEntity<>(nuevaEducacion, HttpStatus.CREATED);
        
    }
        
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducacion (@PathVariable("id") Long idEducacion){
        eduService.deleteEducacion(idEducacion);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
