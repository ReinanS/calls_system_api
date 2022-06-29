package edu.com.pweb.calls_system.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import edu.com.pweb.calls_system.model.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClienteOut {
    private Long id;
    private UsuarioOut usuario;
    private String nome;
    private String cnpj;
    private String endereco;
    private LocalDate dataCadastro;

    public ClienteOut(Cliente cliente) {
        this.id = cliente.getId();
        this.usuario = new UsuarioOut(cliente.getUsuario());
        this.nome = cliente.getNome();
        this.cnpj = cliente.getCnpj();
        this.endereco = cliente.getEndereco();
        this.dataCadastro = cliente.getDataCadastro();
    }

    public static List<ClienteOut> converte(List<Cliente> lista) {
        return lista.stream().map(ClienteOut::new).collect(Collectors.toList());
    }
}
