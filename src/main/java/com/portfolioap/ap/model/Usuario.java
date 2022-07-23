
package com.portfolioap.ap.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    public Long id;
    
    private String nombre;
    private String apellido;
    private String titulo;
    private String descripcion;
    private String fotoPerfil;
    
    @OneToMany(mappedBy = "idEducacion")
    private List<Educacion> educacionUsuario;
    
    @OneToMany(mappedBy = "idHabilidad")
    private List<Habilidad> habilidadUsuario;
    
    @OneToMany (mappedBy = "idExperiencia")
    private List<Experiencia> experienciaUsuario;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String titulo, String descripcion, String fotoPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fotoPerfil = fotoPerfil;
    }

    public Usuario(Long id, String nombre, String apellido, String titulo, String descripcion, String fotoPerfil, List<Educacion> educacionUsuario, List<Habilidad> habilidadUsuario, List<Experiencia> experienciaUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fotoPerfil = fotoPerfil;
        this.educacionUsuario = educacionUsuario;
        this.habilidadUsuario = habilidadUsuario;
        this.experienciaUsuario = experienciaUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public List<Educacion> getEducacionUsuario() {
        return educacionUsuario;
    }

    public void setEducacionUsuario(List<Educacion> educacionUsuario) {
        this.educacionUsuario = educacionUsuario;
    }

    public List<Habilidad> getHabilidadUsuario() {
        return habilidadUsuario;
    }

    public void setHabilidadUsuario(List<Habilidad> habilidadUsuario) {
        this.habilidadUsuario = habilidadUsuario;
    }

    public List<Experiencia> getExperienciaUsuario() {
        return experienciaUsuario;
    }

    public void setExperienciaUsuario(List<Experiencia> experienciaUsuario) {
        this.experienciaUsuario = experienciaUsuario;
    }

    
    
    
    
}
