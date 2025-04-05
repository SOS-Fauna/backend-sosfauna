package com.sosfauna.sosfaunaBackend.service;

import com.sosfauna.sosfaunaBackend.mappers.UsuarioMapper;
import com.sosfauna.sosfaunaBackend.model.dto.UsuarioDto;
import com.sosfauna.sosfaunaBackend.model.entity.Usuario;
import com.sosfauna.sosfaunaBackend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UsuarioService {
    private final UsuarioMapper usuarioMapper;

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;

    }
    public UsuarioDto criarUsuario(UsuarioDto dto ) {
        usuarioRepository.findByCpf(dto.cpf()).ifPresent(usuario -> {throw new IllegalArgumentException("Usuario ja cadastrado");});
        Usuario usuario = usuarioMapper.toUsuario(dto);
        return usuarioMapper.toUsuarioDto(usuarioRepository.save(usuario));
    }

    public UsuarioDto buscarUsuario(String cpf) {
        Usuario usuario = usuarioRepository.findByCpf(cpf).orElseThrow(() -> new IllegalArgumentException("Usuario nao encontrado"));
        return usuarioMapper.toUsuarioDto(usuario);
    }

    public UsuarioDto atualizarUsuario(String id, UsuarioDto dto) {

        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException("Usuario nao encontrado"));
        Usuario usuarioAtualizado = usuarioMapper.toUsuario(dto);
        usuarioAtualizado.setId(usuarioExistente.getId());
        return usuarioMapper.toUsuarioDto(usuarioRepository.save(usuarioAtualizado));
    }

    public void deletarUsuario(String id) {

        usuarioRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Usuario nao encontrado"));
        usuarioRepository.deleteById(id);
    }

    public List<UsuarioDto> listarUsuarios() {
        List<Usuario> list = usuarioRepository.findAll();
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Nao existe nenhum usuario cadastrado");
        }
        return list.stream().map(usuarioMapper::toUsuarioDto).collect(Collectors.toList());

    }
}
