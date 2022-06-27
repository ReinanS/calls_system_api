package edu.com.pweb.calls_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.com.pweb.calls_system.model.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long>{
    
    @Query(value = "SELECT * FROM CHAMADOS WHERE CLIENTE_ID = ?", nativeQuery = true)
    List<Chamado> findByClienteId(@Param("idCliente") String idCliente);
}
