
package com.portfolioap.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Habilidad {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String idHabilidad;
    
    private String tituloHabilidad;
    private Integer nivel;
    private String descripcionHabilidad;
    private String imagenHabilidad;
    
}
