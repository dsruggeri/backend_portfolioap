
package com.portfolioap.ap.services;

import com.portfolioap.ap.model.Usuario;
import com.portfolioap.ap.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepo;
    
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }
    
    //CRUD básico
    
    //Guardar unUsuario en la base de datos (este método no lo vamos a usar)
    public Usuario addUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    } 
    
    //Traer un Usuario de la base de datos
    public Usuario getUsuario(String id){
        return usuarioRepo.findById(id).orElse(null);
    } 
    
    //Listar todas los Usuarios
    public List<Usuario> listUsuario(){
        return usuarioRepo.findAll();
    }
    
    //Editar un Usuario recibido por parámetro
    public Usuario editUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
    
    //Eliminar un Usuario de la base de datos
    public void deleteUsuario(String id){
        usuarioRepo.deleteById(id);
    }
    
}
