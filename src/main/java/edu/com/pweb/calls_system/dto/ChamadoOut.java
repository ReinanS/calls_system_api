package edu.com.pweb.calls_system.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import edu.com.pweb.calls_system.model.enums.Assunto;
import edu.com.pweb.calls_system.model.Chamado;
import edu.com.pweb.calls_system.model.enums.Status;
import lombok.Data;

@Data
public class ChamadoOut {
    private Long id;
    private ClienteOut cliente;
    private Assunto assunto;
    private Status status;
    private String complemento;
    private LocalDate dataCadastro;

    public ChamadoOut(Chamado chamado) {
        this.id = chamado.getId();
        this.cliente = new ClienteOut(chamado.getCliente());
        this.assunto = chamado.getAssunto();
        this.status = chamado.getStatus();
        this.complemento = chamado.getComplemento();
        this.dataCadastro = chamado.getDataCadastro();
    }

    public static List<ChamadoOut> converte(List<Chamado> lista) {
        return lista.stream().map(ChamadoOut::new).collect(Collectors.toList());        
    }
}
