
package com.portfolioap.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Educacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String idEducacion;
    
    private String tituloEducacion;
    private String periodo;
    private String descripcionEducacion;
    private String imagenEducacion;
    
}
