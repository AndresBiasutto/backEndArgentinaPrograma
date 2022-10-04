
package com.argentinaPrograma.BackEndArgentinaPrograma.serv;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Educacion;
import com.argentinaPrograma.BackEndArgentinaPrograma.repo.EducacionRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired
    EducacionRepo educacionRepo;
    
    public List<Educacion> list(){
        return educacionRepo.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return educacionRepo.findById(id);
    }
    
    public Optional<Educacion> getByInstitucion(String institucion){
        return educacionRepo.findByInstitucion(institucion);
    }
    
    public void save(Educacion educacion){
        educacionRepo.save(educacion);
    }
    
    public void delete(int id){
        educacionRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educacionRepo.existsById(id);
    }
    
    public boolean existsByInstitucion(String institucion){
        return educacionRepo.existsByInstitucion(institucion);
    }
}
