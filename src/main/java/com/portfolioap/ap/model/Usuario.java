
package com.portfolioap.ap.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Usuario  {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public String id;
    
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
    
}
