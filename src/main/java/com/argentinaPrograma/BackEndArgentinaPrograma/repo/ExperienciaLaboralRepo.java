
package com.argentinaPrograma.BackEndArgentinaPrograma.repo;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepo extends JpaRepository<ExperienciaLaboral, Integer>{
    public Optional<ExperienciaLaboral> findByEmpresa(String empresa);
    public boolean existsByEmpresa(String empresa);
}
