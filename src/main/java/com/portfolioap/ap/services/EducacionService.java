package com.portfolioap.ap.services;

import com.portfolioap.ap.model.Educacion;
import com.portfolioap.ap.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService {

    @Autowired
    EducacionRepository eduRepo;

//    @Autowired
//    public EducacionService(EducacionRepository eduRepo) {
//        this.eduRepo = eduRepo;
//    }

    //CRUD básico
    //Guardar una educacion en la base de datos
    public Educacion addEducacion(Educacion educacion) {
        return eduRepo.save(educacion);
    }

    //Listar todas las Educaciones
    public List<Educacion> listEducacion() {
        return eduRepo.findAll();
    }

    //Traer una Educacion
    public Educacion getEducacion(Long id) {
        return eduRepo.findById(id).orElse(null);
    }

    //Editar una educacion recibida por parámetro
    public Educacion editEducacion(Educacion educacion, Long idEducacion) {
        Educacion eduUpdate = eduRepo.findById(idEducacion).get();
        eduUpdate.setDescripcionEducacion(educacion.getDescripcionEducacion());
        eduUpdate.setImagenEducacion(educacion.getImagenEducacion());
        eduUpdate.setPeriodo(educacion.getPeriodo());
        eduUpdate.setTituloEducacion(educacion.getTituloEducacion());
        return eduRepo.save(eduUpdate);
    }

    //Eliminar una Educacion de la base de datos
    public void deleteEducacion(Long id) {
        eduRepo.deleteById(id);
    }

}
