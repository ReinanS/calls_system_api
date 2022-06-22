package edu.com.pweb.calls_system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "clientes")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String auth;
    
    @NotBlank
    private String nome;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String endereco;

    public Cliente(String auth, String nome, String cnpj, String endereco) {
        this.auth = auth;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }
}
