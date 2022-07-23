
package com.portfolioap.ap.repository;

import com.portfolioap.ap.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
