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

import edu.com.pweb.calls_system.dto.UsuarioIn;
import edu.com.pweb.calls_system.dto.UsuarioOut;
import edu.com.pweb.calls_system.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    final UsuarioService usuarioService;

    @ApiOperation(value = "Retorna todos os usuarios")
    @GetMapping
    public ResponseEntity<List<UsuarioOut>> listAll() {
        List<UsuarioOut> usuarios = usuarioService.listAll();
        return new ResponseEntity<List<UsuarioOut>>(usuarios, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna cliente por id")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioOut> findById(@Valid @PathVariable String id) {
        UsuarioOut usuario = usuarioService.findById(id);
        return new ResponseEntity<UsuarioOut>(usuario, HttpStatus.OK);
    }

    @ApiOperation(value = "Salva cliente")
    @PostMapping
    public ResponseEntity<UsuarioOut> save(@Valid @RequestBody UsuarioIn usuarioIn) {
        UsuarioOut UsuarioOut = usuarioService.save(usuarioIn);
        return new ResponseEntity<UsuarioOut>(UsuarioOut, HttpStatus.CREATED);

    }
   
    @ApiOperation(value = "Atualiza cliente")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UsuarioIn usuarioIn) {
       usuarioService.update(id, usuarioIn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Deleta cliente")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable String id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
