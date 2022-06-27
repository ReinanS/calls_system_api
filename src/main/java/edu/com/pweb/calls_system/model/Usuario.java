package edu.com.pweb.calls_system.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "usuarios")
public class Usuario {
    
    @Id
    @NotBlank
    private String uid;

    @NotBlank
    private String nome;

    @NotBlank @Email
    private String email;

    @Lob
    private byte[] foto;
}
