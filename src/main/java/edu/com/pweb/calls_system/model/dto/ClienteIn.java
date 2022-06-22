package edu.com.pweb.calls_system.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class ClienteIn {

    @NotBlank
    private String auth;

    @NotBlank
    private String nome;

    @NotBlank 
    private String cnpj;

    @NotBlank
    private String endereco;
}
