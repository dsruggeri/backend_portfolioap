
package com.portfolioap.ap.security.controller;

import com.portfolioap.ap.DTO.Mensaje;
import com.portfolioap.ap.security.AuthRequest;
import com.portfolioap.ap.security.AuthResponse;
import com.portfolioap.ap.security.DTO.JwtDTO;
import com.portfolioap.ap.security.DTO.LoginUser;
import com.portfolioap.ap.security.DTO.NuevoUser;
import com.portfolioap.ap.security.enums.RolNombre;
import com.portfolioap.ap.security.jwt.JwtProvider;
import com.portfolioap.ap.security.model.Rol;
import com.portfolioap.ap.security.model.User;
import com.portfolioap.ap.security.service.RolService;
import com.portfolioap.ap.security.service.UserService;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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
    AuthenticationManager authManager;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    UserService userService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
            
            
    
    @PostMapping("/nuevoUser")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUser nuevoUser, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Error en los campos"),HttpStatus.BAD_REQUEST);
        
        if (userService.existsByEmail(nuevoUser.getEmail()))
            return new ResponseEntity(new Mensaje("El mail ya existe"), HttpStatus.BAD_REQUEST);
        
        User user = new User(nuevoUser.getEmail(), passwordEncoder.encode(nuevoUser.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        
        return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Error en los campos"),HttpStatus.BAD_REQUEST);
        
        Authentication authentication = 
                authManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(),
                loginUser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
        
    }
    
}
