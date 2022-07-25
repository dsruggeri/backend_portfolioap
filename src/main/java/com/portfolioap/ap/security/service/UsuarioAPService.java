
package com.portfolioap.ap.security.service;

import com.portfolioap.ap.security.entity.UsuarioAP;
import com.portfolioap.ap.security.repository.IUsuarioAPRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioAPService {
    
    @Autowired
    IUsuarioAPRepository iUsuarioAPRepository;
    
    public Optional<UsuarioAP> geyByNombreUsuario(String nombreUsuario){
        return iUsuarioAPRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iUsuarioAPRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iUsuarioAPRepository.existsByEmail(email);
    }
    
    public void save(UsuarioAP usuarioAP){
        iUsuarioAPRepository.save(usuarioAP);
    }
    
}
