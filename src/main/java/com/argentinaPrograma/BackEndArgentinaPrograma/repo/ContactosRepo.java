
package com.argentinaPrograma.BackEndArgentinaPrograma.repo;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Contactos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactosRepo extends JpaRepository<Contactos, Integer>{
    Optional<Contactos> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
