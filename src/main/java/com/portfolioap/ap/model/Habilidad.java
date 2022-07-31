
package com.portfolioap.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
public class Habilidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHabilidad;
    
    private String tituloHabilidad;
    private Integer nivel;
    private String descripcionHabilidad;
    private String imagenHabilidad;

    public Habilidad() {
    }

    public Habilidad(Long idHabilidad, String tituloHabilidad, Integer nivel, String descripcionHabilidad, String imagenHabilidad) {
        this.idHabilidad = idHabilidad;
        this.tituloHabilidad = tituloHabilidad;
        this.nivel = nivel;
        this.descripcionHabilidad = descripcionHabilidad;
        this.imagenHabilidad = imagenHabilidad;
    }

    public Habilidad(String tituloHabilidad, Integer nivel, String descripcionHabilidad, String imagenHabilidad) {
        this.tituloHabilidad = tituloHabilidad;
        this.nivel = nivel;
        this.descripcionHabilidad = descripcionHabilidad;
        this.imagenHabilidad = imagenHabilidad;
    }

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public String getTituloHabilidad() {
        return tituloHabilidad;
    }

    public void setTituloHabilidad(String tituloHabilidad) {
        this.tituloHabilidad = tituloHabilidad;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getDescripcionHabilidad() {
        return descripcionHabilidad;
    }

    public void setDescripcionHabilidad(String descripcionHabilidad) {
        this.descripcionHabilidad = descripcionHabilidad;
    }

    public String getImagenHabilidad() {
        return imagenHabilidad;
    }

    public void setImagenHabilidad(String imagenHabilidad) {
        this.imagenHabilidad = imagenHabilidad;
    }

    
    
    
    
}
