package edu.com.pweb.calls_system.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class ClienteIn {
    @NotBlank
    private String usuarioId;

    @NotBlank
    private String nome;
    
    @NotBlank @Email
    private String email;

    private String cnpj;

    private String endereco;

    private LocalDate dataCadastro;
}
