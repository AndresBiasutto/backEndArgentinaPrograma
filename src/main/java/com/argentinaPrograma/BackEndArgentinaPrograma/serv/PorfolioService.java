
package com.argentinaPrograma.BackEndArgentinaPrograma.serv;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Porfolio;
import com.argentinaPrograma.BackEndArgentinaPrograma.repo.PorfolioRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PorfolioService {
    @Autowired
    PorfolioRepo porfolioRepo;
    
    public List<Porfolio> list(){
        return porfolioRepo.findAll();
    }
    
    public Optional<Porfolio> getOne(int id){
        return porfolioRepo.findById(id);
    }
    
    public Optional<Porfolio> getByNombre(String titulo){
        return porfolioRepo.findByTitulo(titulo);
    }
    
    public void save(Porfolio porfolio){
        porfolioRepo.save(porfolio);
    }
    
    public void delete(int id){
        porfolioRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return porfolioRepo.existsById(id);
    }
    
    public boolean existsByNombre(String titulo){
        return porfolioRepo.existsByTitulo(titulo);
    }
}
