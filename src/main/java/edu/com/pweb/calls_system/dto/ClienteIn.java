package edu.com.pweb.calls_system.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class ClienteIn {
    @NotBlank
    private String usuarioId;

    @NotBlank
    private String nome;

    private String cnpj;

    private String endereco;
}
