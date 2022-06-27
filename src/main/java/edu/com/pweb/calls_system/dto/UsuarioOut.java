package edu.com.pweb.calls_system.dto;

import java.util.List;
import java.util.stream.Collectors;

import edu.com.pweb.calls_system.model.Usuario;
import lombok.Data;

@Data
public class UsuarioOut {
    private String uid;
    private String nome;
    private String email;
    private byte[] foto;

    public UsuarioOut(Usuario usuario) {
        this.uid = usuario.getUid();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.foto = usuario.getFoto();
    }

    public static List<UsuarioOut> converte(List<Usuario> lista) {
        return lista.stream().map(UsuarioOut::new).collect(Collectors.toList());
    }
}
