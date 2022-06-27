package edu.com.pweb.calls_system.dto;

import java.time.LocalDate;

import edu.com.pweb.calls_system.model.enums.Assunto;
import edu.com.pweb.calls_system.model.enums.Status;
import lombok.Data;

@Data
public class ChamadoIn {
    
    private Long clienteId;
    
    private Assunto assunto;
    private Status status;
    private LocalDate dataCadastro;
}
