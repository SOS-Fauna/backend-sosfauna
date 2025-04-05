package com.sosfauna.sosfaunaBackend.controller;

import com.sosfauna.sosfaunaBackend.model.dto.UsuarioDto;
import com.sosfauna.sosfaunaBackend.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/Create")
    public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody @Valid UsuarioDto dto) {
        UsuarioDto usuarioDto = usuarioService.criarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
    }

    @GetMapping("findByCpf/{cpf}")
    public ResponseEntity<UsuarioDto> buscarUsuario(@PathVariable String cpf) {
        return ResponseEntity.ok().body(usuarioService.buscarUsuario(cpf));
    }

    @PutMapping("UpdateById/{id}")
    public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable String id, @RequestBody @Valid UsuarioDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.atualizarUsuario(id, dto));
    }

    @DeleteMapping("DeleteById/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        return ResponseEntity.ok().body(usuarioService.listarUsuarios());
    }
}
