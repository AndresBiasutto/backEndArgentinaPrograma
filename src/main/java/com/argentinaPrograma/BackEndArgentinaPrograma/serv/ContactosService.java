
package com.argentinaPrograma.BackEndArgentinaPrograma.serv;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Contactos;
import com.argentinaPrograma.BackEndArgentinaPrograma.repo.ContactosRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContactosService {
    @Autowired
    ContactosRepo contactoRepo;
    
    
    public List<Contactos> list(){
        return contactoRepo.findAll();
    }
    
    public Optional<Contactos> getOne(int id){
        return contactoRepo.findById(id);
    }
    
    public Optional<Contactos> getByNombre(String nombre){
        return contactoRepo.findByNombre(nombre);
    }
    
    public void save(Contactos contactos){
        contactoRepo.save(contactos);
    }
    
    public void delete(int id){
        contactoRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return contactoRepo.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return contactoRepo.existsByNombre(nombre);
    }
}
