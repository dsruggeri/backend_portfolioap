
package com.portfolioap.ap.controller;

import com.portfolioap.ap.model.Habilidad;
import com.portfolioap.ap.services.HabilidadService;
import java.util.List;
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
@RequestMapping("/habilidad")
//@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadController {
    
    private final HabilidadService habilidadService;
    
    public HabilidadController(HabilidadService habilidadService){
        this.habilidadService = habilidadService;
    }
    
    //Traer una habilidad (no lo vamos a usar)
    @GetMapping("/id/{id}")
    public ResponseEntity<Habilidad> getHabilidad(@PathVariable("id") Long idHabilidad) {
        Habilidad habilidad = habilidadService.getHabilidad(idHabilidad);
        return new ResponseEntity<>(habilidad, HttpStatus.OK);
    }

    //trae TODAS las habilidades
    @GetMapping("/listar")
    public ResponseEntity<List<Habilidad>> listHabilidad() {
        List<Habilidad> habLista = habilidadService.listHabilidad();
        return new ResponseEntity<>(habLista, HttpStatus.OK);
    }

    //Editar habilidad
    //@PreAuthorize("HasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Habilidad> editHabilidad(@PathVariable("id") Long idHabilidad, @RequestBody Habilidad habilidad) {
        Habilidad habUpdate = habilidadService.editHabilidad(habilidad, idHabilidad);
        return new ResponseEntity<>(habUpdate, HttpStatus.OK);
    }

    //agregar habilidad
    //@PreAuthorize("HasRole('ROLE_ADMIN')")
    @PostMapping("/agregar")
    public ResponseEntity<Habilidad> addHabilidad(@RequestBody Habilidad habilidad) {
        Habilidad nuevaHabilidad = habilidadService.addHabilidad(habilidad);
        return new ResponseEntity<>(nuevaHabilidad, HttpStatus.CREATED);

    }

    //borrar habilidad
    //@PreAuthorize("HasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHabilidad(@PathVariable("id") Long idHabilidad) {
        habilidadService.deleteHabilidad(idHabilidad);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
