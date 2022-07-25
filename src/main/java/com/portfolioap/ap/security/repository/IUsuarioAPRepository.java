
package com.portfolioap.ap.security.repository;

import com.portfolioap.ap.security.entity.UsuarioAP;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioAPRepository extends JpaRepository<UsuarioAP, Integer> {
    Optional<UsuarioAP> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario);
    
    boolean existsByEmail(String email);
    
    
}
