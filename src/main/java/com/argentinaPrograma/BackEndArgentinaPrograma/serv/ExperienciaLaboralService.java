
package com.argentinaPrograma.BackEndArgentinaPrograma.serv;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.ExperienciaLaboral;
import com.argentinaPrograma.BackEndArgentinaPrograma.repo.ExperienciaLaboralRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaLaboralService {
    @Autowired
     ExperienciaLaboralRepo rExperiencia;
     
     public List<ExperienciaLaboral> list(){
         return rExperiencia.findAll();
     }
     
     public Optional<ExperienciaLaboral> getOne(int id){
         return rExperiencia.findById(id);
     }
     
     public Optional<ExperienciaLaboral> getByNombreE(String empresa){
         return rExperiencia.findByEmpresa(empresa);
     }
     
     public void save(ExperienciaLaboral expe){
         rExperiencia.save(expe);
     }
     
     public void delete(int id){
         rExperiencia.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rExperiencia.existsById(id);
     }
     
     public boolean existsByNombreE(String empresa){
         return rExperiencia.existsByEmpresa(empresa);
     }
}
