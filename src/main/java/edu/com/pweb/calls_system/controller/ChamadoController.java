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

import edu.com.pweb.calls_system.model.dto.ChamadoIn;
import edu.com.pweb.calls_system.model.dto.ChamadoOut;
import edu.com.pweb.calls_system.service.ChamadoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    final ChamadoService chamadoService;

    @GetMapping
    public ResponseEntity<List<ChamadoOut>> listAll() {
        List<ChamadoOut> chamados = chamadoService.listAll();
        return new ResponseEntity<List<ChamadoOut>>(chamados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoOut> findById(@Valid @PathVariable Long id) {
        ChamadoOut usuario = chamadoService.findById(id);
        return new ResponseEntity<ChamadoOut>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChamadoOut> save(@Valid @RequestBody ChamadoIn chamadoIn) {
        ChamadoOut chamadoOut = chamadoService.save(chamadoIn);
        return new ResponseEntity<ChamadoOut>(chamadoOut, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody ChamadoIn chamadoIn) {
        chamadoService.update(id, chamadoIn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        chamadoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
