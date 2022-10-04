
package com.argentinaPrograma.BackEndArgentinaPrograma.repo;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepo extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByInstitucion(String institucion);
    public boolean existsByInstitucion(String institucion);
}
