
package com.portfolioap.ap.security.repository;

import com.portfolioap.ap.security.entity.Rol;
import com.portfolioap.ap.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rol);
    
}
