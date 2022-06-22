package edu.com.pweb.calls_system.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.com.pweb.calls_system.model.Cliente;
import edu.com.pweb.calls_system.model.dto.ClienteIn;
import edu.com.pweb.calls_system.model.dto.ClienteOut;
import edu.com.pweb.calls_system.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    public Cliente findByIdOrThrowNotFoundRequestException(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
    }

    public ClienteOut save(ClienteIn clienteIn) {
        Cliente cliente = modelMapper.map(clienteIn, Cliente.class);
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
        Cliente cliente = new Cliente(savedCliente.getId(), clienteIn.getAuth(), clienteIn.getNome(), clienteIn.getCnpj(), clienteIn.getEndereco());
    
        clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.delete(findByIdOrThrowNotFoundRequestException(id));
    }

}
