package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.UsuarioDto;
import com.sosfauna.sosfaunaBackend.model.entity.Usuario;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-10T03:14:36-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toUsuario(UsuarioDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setCpf( usuarioDto.cpf() );
        usuario.setNome( usuarioDto.nome() );
        usuario.setDataNascimento( usuarioDto.dataNascimento() );
        usuario.setTelefone( usuarioDto.telefone() );
        usuario.setAcesso( usuarioDto.acesso() );

        return usuario;
    }

    @Override
    public UsuarioDto toUsuarioDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        String cpf = null;
        String nome = null;
        Date dataNascimento = null;
        String telefone = null;
        boolean acesso = false;

        cpf = usuario.getCpf();
        nome = usuario.getNome();
        dataNascimento = usuario.getDataNascimento();
        telefone = usuario.getTelefone();
        acesso = usuario.isAcesso();

        UsuarioDto usuarioDto = new UsuarioDto( cpf, nome, dataNascimento, telefone, acesso );

        return usuarioDto;
    }
}
