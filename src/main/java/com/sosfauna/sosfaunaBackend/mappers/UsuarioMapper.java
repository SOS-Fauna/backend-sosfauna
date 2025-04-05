package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.UsuarioDto;
import com.sosfauna.sosfaunaBackend.model.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toUsuario(UsuarioDto usuarioDto);
    UsuarioDto toUsuarioDto(Usuario usuario);
}
