
package com.portfolioap.ap.controller;

import com.portfolioap.ap.model.Usuario;
import com.portfolioap.ap.services.UsuarioService;
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
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    private final UsuarioService usuarioService;
    
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") String id){
        Usuario usuario = usuarioService.getUsuario(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Usuario> editUsuario(@RequestBody Usuario usuario){
        Usuario usuarioUpdate = usuarioService.editUsuario(usuario);
        return new ResponseEntity<>(usuarioUpdate, HttpStatus.OK);
    }
    
//    @DeleteMapping
//    public ResponseEntity
    
}
