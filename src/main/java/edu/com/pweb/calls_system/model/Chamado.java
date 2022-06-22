package edu.com.pweb.calls_system.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "chamados")
public class Chamado {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private Assunto assunto;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dataCadastro;


    public Chamado(Cliente cliente, Assunto assunto, Status status, LocalDate dataCadastro) {
        this.cliente = cliente;
        this.assunto = assunto;
        this.status = status;
        this.dataCadastro = dataCadastro;
    }
}
