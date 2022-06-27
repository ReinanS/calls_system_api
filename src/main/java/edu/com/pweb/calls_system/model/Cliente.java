package edu.com.pweb.calls_system.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "clientes")
public class Cliente {

    @Id
    private String id;

    @NotBlank
    private String nome;
    
    @NotBlank
    private String email;

    @Lob
    private byte[] foto;

    private String cnpj;

    private String endereco;

    private LocalDate dataCadastro;

    public Cliente(String nome, String email, byte[] foto,  String cnpj, String endereco, LocalDate dataCadastro) {
      this.nome = nome;
      this.email = email;
      this.foto = foto;
      this.cnpj = cnpj;
      this.endereco = endereco;
      this.dataCadastro = dataCadastro;
    }

    public Cliente(String nome, String email, LocalDate dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }
    
}
