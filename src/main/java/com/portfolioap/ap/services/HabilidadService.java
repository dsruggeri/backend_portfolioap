
package com.portfolioap.ap.services;


import com.portfolioap.ap.model.Habilidad;
import com.portfolioap.ap.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HabilidadService {
    
    private final HabilidadRepository habRepo;
    
    @Autowired
    public HabilidadService(HabilidadRepository habRepo){
        this.habRepo = habRepo;
    }
    
    //CRUD básico
    
    //Guardar una Habilidad en la base de datos
    public Habilidad addHabilidad(Habilidad habilidad){
        return habRepo.save(habilidad);
    } 
    
    //Listar todas las Habilidades
    public List<Habilidad> listHabilidad(){
        return habRepo.findAll();
    }
    
    //Editar una Habilidad recibida por parámetro
    public Habilidad editHabilidad(Habilidad habilidad){
        return habRepo.save(habilidad);
    }
    
    //Eliminar una Habilidad de la base de datos
    public void deleteHabilidad(String id){
        habRepo.deleteById(id);
    }
    
    //Traer una habilidad por id
    public Habilidad getHabilidad(String id){
        return habRepo.findById(id).orElse(null);
    }
    
}
