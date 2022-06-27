package edu.com.pweb.calls_system.dto;

import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class UsuarioIn {
    
    @NotBlank
    private String uid;

    @NotBlank
    private String nome;

    @NotBlank @Email
    private String email;

    @Lob
    private byte[] foto;
}
