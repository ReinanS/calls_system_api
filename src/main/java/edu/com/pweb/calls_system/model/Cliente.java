package edu.com.pweb.calls_system.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "clientes")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @NotBlank
    private String nome;
    
    @NotBlank @Email
    private String email;
    
    private String cnpj;

    private String endereco;

    private LocalDate dataCadastro;

    public Cliente(Usuario usuario, String nome, String email,  String cnpj, String endereco, LocalDate dataCadastro) {
      this.usuario = usuario;
      this.nome = nome;
      this.email = email;
      this.cnpj = cnpj;
      this.endereco = endereco;
      this.dataCadastro = dataCadastro;
    }
    
}
