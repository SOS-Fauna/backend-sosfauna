package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.DenunciaRequestDto;
import com.sosfauna.sosfaunaBackend.model.dto.DenunciaResponseDto;
import com.sosfauna.sosfaunaBackend.model.entity.Denuncia;
import com.sosfauna.sosfaunaBackend.model.enumerated.StatusDenuncia;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-08T17:37:48-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class DenunciaMapperImpl implements DenunciaMapper {

    @Override
    public Denuncia transicao(DenunciaRequestDto dto, Denuncia denuncia) {
        if ( dto == null ) {
            return denuncia;
        }

        denuncia.setAnimal( dto.animal() );
        denuncia.setDenunciado( dto.denunciado() );
        denuncia.setDescricao( dto.descricao() );
        denuncia.setDataOcorrido( dto.dataOcorrido() );
        denuncia.setHoraOcorrido( dto.horaOcorrido() );
        denuncia.setBairro( dto.bairro() );
        denuncia.setNumero( dto.numero() );
        denuncia.setRua( dto.rua() );
        denuncia.setCep( dto.cep() );

        return denuncia;
    }

    @Override
    public DenunciaResponseDto toResponseDto(Denuncia denuncia) {
        if ( denuncia == null ) {
            return null;
        }

        String id = null;
        String animal = null;
        String denunciado = null;
        String descricao = null;
        LocalDate dataOcorrido = null;
        LocalTime horaOcorrido = null;
        String bairro = null;
        String numero = null;
        String rua = null;
        String cep = null;
        StatusDenuncia statusDenuncia = null;

        id = denuncia.getId();
        animal = denuncia.getAnimal();
        denunciado = denuncia.getDenunciado();
        descricao = denuncia.getDescricao();
        dataOcorrido = denuncia.getDataOcorrido();
        horaOcorrido = denuncia.getHoraOcorrido();
        bairro = denuncia.getBairro();
        numero = denuncia.getNumero();
        rua = denuncia.getRua();
        cep = denuncia.getCep();
        statusDenuncia = denuncia.getStatusDenuncia();

        String imagemUrl = null;
        String nomeOrgao = denuncia.getOrgao() != null ? denuncia.getOrgao().getNome() : null;
        String idOrgao = null;
        String idUsuario = null;
        LocalDateTime dataCriacao = null;

        DenunciaResponseDto denunciaResponseDto = new DenunciaResponseDto( id, imagemUrl, animal, denunciado, descricao, dataOcorrido, horaOcorrido, bairro, numero, rua, cep, idOrgao, idUsuario, nomeOrgao, dataCriacao, statusDenuncia );

        return denunciaResponseDto;
    }
}
