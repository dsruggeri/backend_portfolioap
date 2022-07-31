
package com.portfolioap.ap.security.repository;

import com.portfolioap.ap.security.enums.RolNombre;
import com.portfolioap.ap.security.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre( RolNombre rolNombre);
    
}
