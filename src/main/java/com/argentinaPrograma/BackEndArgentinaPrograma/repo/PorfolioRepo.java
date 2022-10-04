
package com.argentinaPrograma.BackEndArgentinaPrograma.repo;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Porfolio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorfolioRepo extends JpaRepository<Porfolio, Integer>{
    Optional<Porfolio> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
