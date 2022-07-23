
package com.portfolioap.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExperiencia;
    
    private String tituloExperiencia;
    private String fecha;
    private String descripcionExperiencia;
    private String imagenExperiencia;

    public Experiencia() {
    }

    public Experiencia(String tituloExperiencia, String fecha, String descripcionExperiencia, String imagenExperiencia) {
        this.tituloExperiencia = tituloExperiencia;
        this.fecha = fecha;
        this.descripcionExperiencia = descripcionExperiencia;
        this.imagenExperiencia = imagenExperiencia;
    }

    public Experiencia(Long idExperiencia, String tituloExperiencia, String fecha, String descripcionExperiencia, String imagenExperiencia) {
        this.idExperiencia = idExperiencia;
        this.tituloExperiencia = tituloExperiencia;
        this.fecha = fecha;
        this.descripcionExperiencia = descripcionExperiencia;
        this.imagenExperiencia = imagenExperiencia;
    }

    public Long getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(Long idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public String getTituloExperiencia() {
        return tituloExperiencia;
    }

    public void setTituloExperiencia(String tituloExperiencia) {
        this.tituloExperiencia = tituloExperiencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionExperiencia() {
        return descripcionExperiencia;
    }

    public void setDescripcionExperiencia(String descripcionExperiencia) {
        this.descripcionExperiencia = descripcionExperiencia;
    }

    public String getImagenExperiencia() {
        return imagenExperiencia;
    }

    public void setImagenExperiencia(String imagenExperiencia) {
        this.imagenExperiencia = imagenExperiencia;
    }

    
    
    
    
}
