
package com.portfolioap.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEducacion;
    
    private String tituloEducacion;
    private String periodo;
    private String descripcionEducacion;
    private String imagenEducacion;

    public Educacion() {
    }

    public Educacion(String tituloEducacion, String periodo, String descripcionEducacion, String imagenEducacion) {
        this.tituloEducacion = tituloEducacion;
        this.periodo = periodo;
        this.descripcionEducacion = descripcionEducacion;
        this.imagenEducacion = imagenEducacion;
    }

    public Educacion(Long idEducacion, String tituloEducacion, String periodo, String descripcionEducacion, String imagenEducacion) {
        this.idEducacion = idEducacion;
        this.tituloEducacion = tituloEducacion;
        this.periodo = periodo;
        this.descripcionEducacion = descripcionEducacion;
        this.imagenEducacion = imagenEducacion;
    }

    public Long getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Long idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getTituloEducacion() {
        return tituloEducacion;
    }

    public void setTituloEducacion(String tituloEducacion) {
        this.tituloEducacion = tituloEducacion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcionEducacion() {
        return descripcionEducacion;
    }

    public void setDescripcionEducacion(String descripcionEducacion) {
        this.descripcionEducacion = descripcionEducacion;
    }

    public String getImagenEducacion() {
        return imagenEducacion;
    }

    public void setImagenEducacion(String imagenEducacion) {
        this.imagenEducacion = imagenEducacion;
    }

    


    
    

    
    
    
    
}
