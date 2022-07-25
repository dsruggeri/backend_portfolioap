
package com.portfolioap.ap.security.service;

import com.portfolioap.ap.security.entity.UsuarioAP;
import com.portfolioap.ap.security.entity.UsuarioAPPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    UsuarioAPService usuarioAPService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        UsuarioAP usuarioAP = usuarioAPService.geyByNombreUsuario(nombreUsuario).get();
        return UsuarioAPPrincipal.build(usuarioAP);
    }
    
}
