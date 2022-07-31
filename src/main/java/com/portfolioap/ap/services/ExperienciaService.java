
package com.portfolioap.ap.services;

import com.portfolioap.ap.model.Experiencia;
import com.portfolioap.ap.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {
    
    @Autowired
    ExperienciaRepository expRepo;
    
    
    
    //CRUD básico
    
    //Guardar una Experiencia en la base de datos
    public Experiencia addExperiencia(Experiencia experiencia){
        return expRepo.save(experiencia);
    } 
    
    //Listar todas las Experiencias
    public List<Experiencia> listExperiencia(){
        return expRepo.findAll();
    }
    
    //Editar una Experiencia recibida por parámetro
    public Experiencia editExperiencia(Experiencia experiencia, Long idExperiencia){
        Experiencia expUpdate = expRepo.findById(idExperiencia).get();
        expUpdate.setTituloExperiencia(experiencia.getTituloExperiencia());
        expUpdate.setDescripcionExperiencia(experiencia.getDescripcionExperiencia());
        expUpdate.setFecha(experiencia.getFecha());
        expUpdate.setImagenExperiencia(experiencia.getImagenExperiencia());
        return expRepo.save(expUpdate);
    }
    
    //Eliminar una Experiencia de la base de datos
    public void deleteExperiencia(Long id){
        expRepo.deleteById(id);
    }
    
    //Traer por id
    public Experiencia getExperiencia(Long id){
        return expRepo.findById(id).orElse(null);
        
    }
    
}
