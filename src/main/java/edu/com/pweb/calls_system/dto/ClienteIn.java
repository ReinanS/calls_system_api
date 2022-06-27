package edu.com.pweb.calls_system.dto;

import java.time.LocalDate;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class ClienteIn {

    @NotBlank String id;
 
    @NotBlank
    private String nome;
    
    @NotBlank
    private String email;

    @Lob
    private byte[] foto;

    private String cnpj;

    private String endereco;

    private LocalDate dataCadastro;
}
