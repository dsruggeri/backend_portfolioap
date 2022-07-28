
package com.portfolioap.ap.repository;

import com.portfolioap.ap.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
