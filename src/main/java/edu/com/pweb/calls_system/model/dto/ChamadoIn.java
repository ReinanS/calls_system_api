package edu.com.pweb.calls_system.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import edu.com.pweb.calls_system.model.Assunto;
import edu.com.pweb.calls_system.model.Status;
import lombok.Data;

@Data
public class ChamadoIn {
    
    @NotNull
    private Long idCliente;
    
    private Assunto assunto;
    private Status status;
    private LocalDate dataCadastro;

}
