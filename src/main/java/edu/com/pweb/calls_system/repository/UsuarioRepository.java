package edu.com.pweb.calls_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.com.pweb.calls_system.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    
}
