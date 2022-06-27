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
    List<Chamado> findByClienteId(@Param("clientId") Long clientId);

    @Query(value = "SELECT CHAMADOS.ID, CHAMADOS.ASSUNTO, CHAMADOS.DATA_CADASTRO, CHAMADOS.STATUS, CHAMADOS.CLIENTE_ID FROM CHAMADOS INNER JOIN CLIENTES ON CHAMADOS.CLIENTE_ID = CLIENTES.ID WHERE CLIENTES.USUARIO_UID = ?", nativeQuery = true)
    List<Chamado> findByUsuarioId(@Param("usuarioId") String usuarioId);
}
