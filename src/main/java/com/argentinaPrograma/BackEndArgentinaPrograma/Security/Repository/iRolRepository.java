
package com.argentinaPrograma.BackEndArgentinaPrograma.Security.Repository;

import com.argentinaPrograma.BackEndArgentinaPrograma.Security.Entity.Rol;
import com.argentinaPrograma.BackEndArgentinaPrograma.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
