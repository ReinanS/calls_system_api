package edu.com.pweb.calls_system.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.com.pweb.calls_system.dto.ClienteIn;
import edu.com.pweb.calls_system.dto.ClienteOut;
import edu.com.pweb.calls_system.model.Cliente;
import edu.com.pweb.calls_system.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente findByIdOrThrowNotFoundRequestException(String id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
    }

    public ClienteOut save(ClienteIn clienteIn) {
        // Encontrou usuário, então salve o cliente    
        Cliente cliente = new Cliente(clienteIn.getId(), clienteIn.getNome(), clienteIn.getEmail(), clienteIn.getFoto(), clienteIn.getCnpj(), clienteIn.getEndereco(), clienteIn.getDataCadastro());
        cliente = clienteRepository.save(cliente);

        return new ClienteOut(cliente);
    } 

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteOut findById(String id) {
        return new ClienteOut(findByIdOrThrowNotFoundRequestException(id));
    }

    public List<ClienteOut> listAll() {
        return ClienteOut.converte(clienteRepository.findAll());
    }

    public void update(String id, ClienteIn clienteIn) {
        Cliente savedCliente = findByIdOrThrowNotFoundRequestException(id);
        Cliente cliente = new Cliente(savedCliente.getId(), clienteIn.getNome(), clienteIn.getEmail(), clienteIn.getFoto(), clienteIn.getCnpj(), clienteIn.getEndereco(), clienteIn.getDataCadastro());
    
        clienteRepository.save(cliente);
    }

    public void delete(String id) {
        clienteRepository.delete(findByIdOrThrowNotFoundRequestException(id));
    }

}
