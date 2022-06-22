package edu.com.pweb.calls_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.com.pweb.calls_system.model.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long>{
    
}
