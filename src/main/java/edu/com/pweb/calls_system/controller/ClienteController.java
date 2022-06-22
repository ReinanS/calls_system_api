package edu.com.pweb.calls_system.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.pweb.calls_system.model.dto.ClienteIn;
import edu.com.pweb.calls_system.model.dto.ClienteOut;
import edu.com.pweb.calls_system.service.ClienteService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteOut>> listAll() {
        List<ClienteOut> clientes = clienteService.listAll();
        return new ResponseEntity<List<ClienteOut>>(clientes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteOut> save(@Valid @RequestBody ClienteIn clienteIn) {
        ClienteOut clienteOut = clienteService.save(clienteIn);
        return new ResponseEntity<ClienteOut>(clienteOut, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteOut> findById(@Valid @PathVariable Long id) {
        ClienteOut usuario = clienteService.findById(id);
        return new ResponseEntity<ClienteOut>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ClienteIn clienteIn) {
       clienteService.update(id, clienteIn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
