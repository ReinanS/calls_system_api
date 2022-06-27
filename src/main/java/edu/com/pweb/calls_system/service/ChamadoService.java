package edu.com.pweb.calls_system.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.com.pweb.calls_system.dto.ChamadoIn;
import edu.com.pweb.calls_system.dto.ChamadoOut;
import edu.com.pweb.calls_system.model.Chamado;
import edu.com.pweb.calls_system.model.Cliente;
import edu.com.pweb.calls_system.repository.ChamadoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ChamadoService {
    private final ChamadoRepository chamadoRepository;
    private final ClienteService clienteService;

    public Chamado findByIdOrThrowNotFoundRequestException(Long id) {
        return chamadoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chamado não encontrado"));
    }

    public ChamadoOut save(ChamadoIn chamadoIn) {
        Cliente cliente = clienteService.findByIdOrThrowNotFoundRequestException(chamadoIn.getClienteId());
        Chamado chamado = new Chamado(cliente, chamadoIn.getAssunto(), chamadoIn.getStatus(), chamadoIn.getDataCadastro());
       
        chamado = chamadoRepository.save(chamado);
        
       return new ChamadoOut(chamado);
    }

    public ChamadoOut findById(Long id) {
        return new ChamadoOut(findByIdOrThrowNotFoundRequestException(id));
    }

    public List<ChamadoOut> listAll(Long clienteId) {
        return ChamadoOut.converte(chamadoRepository.findByClienteId(clienteId));
    }

    public List<ChamadoOut> listAll(String usuarioId) {
        return ChamadoOut.converte(chamadoRepository.findByUsuarioId(usuarioId));
    }

    public void update(Long id, ChamadoIn chamadoIn) {
        Chamado savedChamado = findByIdOrThrowNotFoundRequestException(id);
        Chamado chamado = new Chamado(savedChamado.getId() ,savedChamado.getCliente(), chamadoIn.getAssunto(), chamadoIn.getStatus(), chamadoIn.getDataCadastro());
        
        chamadoRepository.save(chamado);
    }

    public void delete(Long id) {
        chamadoRepository.delete(findByIdOrThrowNotFoundRequestException(id));
    }

}
