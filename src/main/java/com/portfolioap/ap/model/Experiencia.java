
package com.portfolioap.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String idExperiencia;
    
    private String tituloExperiencia;
    private String fecha;
    private String descripcionExperiencia;
    private String imagenExperiencia;
    
}
