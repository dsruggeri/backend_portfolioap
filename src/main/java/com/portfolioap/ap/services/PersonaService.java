
package com.portfolioap.ap.services;

import com.portfolioap.ap.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolioap.ap.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService {
    
    @Autowired
    PersonaRepository personaRepo;
    
    
    
    //CRUD básico
    
    //Guardar unUsuario en la base de datos (este método no lo vamos a usar)
    public Persona addPersona(Persona persona){
        return personaRepo.save(persona);
    } 
    
    //Traer un Persona de la base de datos
    public Persona getPersona(Long id){
        return personaRepo.findById(id).orElse(null);
    } 
    
    //Listar todas los Usuarios
    public List<Persona> listPersona(){
        return personaRepo.findAll();
    }
    
    //Editar un Persona recibido por parámetro
    public Persona editPersona(Persona persona, Long id){
        Persona personaUpdate = personaRepo.findById(id).get();
        personaUpdate.setApellido(persona.getApellido());
        personaUpdate.setNombre(persona.getNombre());
        personaUpdate.setDescripcion(persona.getDescripcion());
        personaUpdate.setFotoPerfil(persona.getFotoPerfil());
        personaUpdate.setTitulo(persona.getTitulo());
        
        
        return personaRepo.save(personaUpdate);
    }
    
    //Eliminar un Persona de la base de datos
    public void deletePersona(Long id){
        personaRepo.deleteById(id);
    }
    
}
