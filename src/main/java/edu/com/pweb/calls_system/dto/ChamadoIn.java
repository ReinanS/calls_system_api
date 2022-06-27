package edu.com.pweb.calls_system.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import edu.com.pweb.calls_system.model.enums.Assunto;
import edu.com.pweb.calls_system.model.enums.Status;
import lombok.Data;

@Data
public class ChamadoIn {
    
    @NotBlank
    private String idCliente;
    
    private Assunto assunto;
    private Status status;
    private LocalDate dataCadastro;

}