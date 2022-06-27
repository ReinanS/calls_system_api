package edu.com.pweb.calls_system.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.pweb.calls_system.dto.ClienteIn;
import edu.com.pweb.calls_system.dto.ClienteOut;
import edu.com.pweb.calls_system.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    final ClienteService clienteService;

    @ApiOperation(value = "Retorna todos os clientes")
    @GetMapping
    public ResponseEntity<List<ClienteOut>> listAll() {
        List<ClienteOut> clientes = clienteService.listAll();
        return new ResponseEntity<List<ClienteOut>>(clientes, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna cliente por id")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteOut> findById(@Valid @PathVariable String id) {
        ClienteOut usuario = clienteService.findById(id);
        return new ResponseEntity<ClienteOut>(usuario, HttpStatus.OK);
    }

    @ApiOperation(value = "Salva cliente")
    @PostMapping
    public ResponseEntity<ClienteOut> save(@Valid @RequestBody ClienteIn clienteIn) {
        ClienteOut clienteOut = clienteService.save(clienteIn);
        return new ResponseEntity<ClienteOut>(clienteOut, HttpStatus.CREATED);

    }
   
    @ApiOperation(value = "Atualiza cliente")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ClienteIn clienteIn) {
       clienteService.update(id, clienteIn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Deleta cliente")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable String id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
