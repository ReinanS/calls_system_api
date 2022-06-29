package edu.com.pweb.calls_system.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import edu.com.pweb.calls_system.dto.UsuarioIn;
import edu.com.pweb.calls_system.dto.UsuarioOut;
import edu.com.pweb.calls_system.model.Usuario;
import edu.com.pweb.calls_system.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario findByIdOrThrowNotFoundRequestException(String id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
    }
    
    public UsuarioOut save(UsuarioIn usuarioIn) {
        Usuario usuario = new Usuario(usuarioIn.getUid(), usuarioIn.getNome(), (usuarioIn.getEmail()), usuarioIn.getFoto());
        usuarioRepository.save(usuario);

        return new UsuarioOut(usuario);
    }

    public UsuarioOut findById(String id) {
        return new UsuarioOut(findByIdOrThrowNotFoundRequestException(id));
    }

    public List<UsuarioOut> listAll() {
        return UsuarioOut.converte(usuarioRepository.findAll());
    }

    public void update(String id, UsuarioIn usuarioIn) {
        Usuario savedUsuario = findByIdOrThrowNotFoundRequestException(id);
        Usuario usuario = new Usuario(savedUsuario.getUid(), usuarioIn.getNome(), savedUsuario.getEmail(), usuarioIn.getFoto());

        usuarioRepository.save(usuario);
    }

    public void update(String id, String nome, MultipartFile img) throws IOException {
        Usuario savedUsuario = findByIdOrThrowNotFoundRequestException(id);
        savedUsuario.setNome(nome);
        savedUsuario.setFoto(img.getBytes());
    }

    public void delete(String id) {
        usuarioRepository.delete(findByIdOrThrowNotFoundRequestException(id));
    }
}
