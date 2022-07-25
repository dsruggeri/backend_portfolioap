package com.portfolioap.ap.security.controller;

import com.portfolioap.ap.security.DTO.JwtDTO;
import com.portfolioap.ap.security.DTO.LoginUsuarioAP;
import com.portfolioap.ap.security.DTO.NuevoUsuarioAP;
import com.portfolioap.ap.security.entity.Rol;
import com.portfolioap.ap.security.entity.UsuarioAP;
import com.portfolioap.ap.security.enums.RolNombre;
import com.portfolioap.ap.security.jwt.JwtProvider;
import com.portfolioap.ap.security.service.RolService;
import com.portfolioap.ap.security.service.UsuarioAPService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UsuarioAPService usuarioAPService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuarioAP nuevoUsuarioAP, BindingResult bindingResult){
        
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Campos incorrectos"), HttpStatus.BAD_REQUEST);
        }
        
        if (usuarioAPService.existsByNombreUsuario(nuevoUsuarioAP.getNombreUsuario())) {
            return new ResponseEntity(new Mensaje("Nombre ya existente"), HttpStatus.BAD_REQUEST);
        }
        
        if (usuarioAPService.existsByEmail(nuevoUsuarioAP.getEmail())){
            return new ResponseEntity(new Mensaje("El email ya está registrado"), HttpStatus.BAD_REQUEST);
        }
        
        UsuarioAP usuarioAP = new UsuarioAP(nuevoUsuarioAP.getNombreUsuario(), 
                nuevoUsuarioAP.getEmail(), 
                passwordEncoder.encode(nuevoUsuarioAP.getPassword())); 
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if (nuevoUsuarioAP.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        
        usuarioAP.setRoles(roles);
        usuarioAPService.save(usuarioAP);
        
        return new ResponseEntity(new Mensaje("Usuario Guardado"), HttpStatus.CREATED);
        
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuarioAP loginUsuarioAP,
            BindingResult bindingResult){
        
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Error en los campos"), HttpStatus.BAD_REQUEST);
        }
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUsuarioAP.getNombreUsuario(), loginUsuarioAP.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }

}
