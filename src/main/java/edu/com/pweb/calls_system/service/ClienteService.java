package edu.com.pweb.calls_system.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.com.pweb.calls_system.dto.ClienteIn;
import edu.com.pweb.calls_system.dto.ClienteOut;
import edu.com.pweb.calls_system.model.Cliente;
import edu.com.pweb.calls_system.model.Usuario;
import edu.com.pweb.calls_system.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final UsuarioService usuarioService;

    public Cliente findByIdOrThrowNotFoundRequestException(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
    }

    public ClienteOut save(ClienteIn clienteIn) {
        Usuario usuario = usuarioService.findByIdOrThrowNotFoundRequestException(clienteIn.getUsuarioId());
        Cliente cliente = new Cliente(usuario, clienteIn.getNome(), clienteIn.getCnpj(), clienteIn.getEndereco(), LocalDate.now());

        cliente = clienteRepository.save(cliente);

        return new ClienteOut(cliente);
    } 

    public ClienteOut findById(Long id) {
        return new ClienteOut(findByIdOrThrowNotFoundRequestException(id));
    }

    public List<ClienteOut> listAll() {
        return ClienteOut.converte(clienteRepository.findAll());
    }

    public void update(Long id, ClienteIn clienteIn) {
        Cliente savedCliente = findByIdOrThrowNotFoundRequestException(id);
        Cliente cliente = new Cliente(savedCliente.getId(), savedCliente.getUsuario(), clienteIn.getNome(), clienteIn.getCnpj(), clienteIn.getEndereco(), savedCliente.getDataCadastro());
    
        clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.delete(findByIdOrThrowNotFoundRequestException(id));
    }

}
