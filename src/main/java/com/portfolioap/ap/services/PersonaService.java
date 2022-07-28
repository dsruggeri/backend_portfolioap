
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
    
    private final PersonaRepository personaRepo;
    
    @Autowired
    public PersonaService(PersonaRepository personaRepo){
        this.personaRepo = personaRepo;
    }
    
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
    public Persona editPersona(Persona persona){
        return personaRepo.save(persona);
    }
    
    //Eliminar un Persona de la base de datos
    public void deletePersona(Long id){
        personaRepo.deleteById(id);
    }
    
}
