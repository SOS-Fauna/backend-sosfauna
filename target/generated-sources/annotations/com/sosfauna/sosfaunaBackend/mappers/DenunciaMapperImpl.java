package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.DenunciaRequestDto;
import com.sosfauna.sosfaunaBackend.model.dto.DenunciaResponseDto;
import com.sosfauna.sosfaunaBackend.model.entity.Denuncia;
import com.sosfauna.sosfaunaBackend.model.enumerated.StatusDenuncia;
import com.sosfauna.sosfaunaBackend.service.CloudinaryService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-10T03:14:37-0300",
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
    public DenunciaResponseDto toResponseDto(Denuncia denuncia, CloudinaryService cloudinaryService) {
        if ( denuncia == null ) {
            return null;
        }

        String id = null;
        String protocolo = null;
        String animal = null;
        String denunciado = null;
        String descricao = null;
        LocalDate dataOcorrido = null;
        LocalTime horaOcorrido = null;
        String bairro = null;
        String numero = null;
        String rua = null;
        String cep = null;
        LocalDateTime dataCriacao = null;
        StatusDenuncia statusDenuncia = null;

        id = denuncia.getId();
        protocolo = denuncia.getProtocolo();
        animal = denuncia.getAnimal();
        denunciado = denuncia.getDenunciado();
        descricao = denuncia.getDescricao();
        dataOcorrido = denuncia.getDataOcorrido();
        horaOcorrido = denuncia.getHoraOcorrido();
        bairro = denuncia.getBairro();
        numero = denuncia.getNumero();
        rua = denuncia.getRua();
        cep = denuncia.getCep();
        dataCriacao = denuncia.getDataCriacao();
        statusDenuncia = denuncia.getStatusDenuncia();

        String imagemUrl = cloudinaryService.getImagemUrl(denuncia.getPublicId());
        String nomeOrgao = denuncia.getOrgao() != null ? denuncia.getOrgao().getNome() : null;
        String idUsuario = denuncia.getUsuario() != null ? denuncia.getUsuario().getId() : null;
        String idOrgao = denuncia.getOrgao() != null ? denuncia.getOrgao().getId() : null;

        DenunciaResponseDto denunciaResponseDto = new DenunciaResponseDto( id, protocolo, imagemUrl, animal, denunciado, descricao, dataOcorrido, horaOcorrido, bairro, numero, rua, cep, idOrgao, idUsuario, nomeOrgao, dataCriacao, statusDenuncia );

        return denunciaResponseDto;
    }

    @Override
    public List<DenunciaResponseDto> toResponseDto(List<Denuncia> denuncia, CloudinaryService cloudinaryService) {
        if ( denuncia == null ) {
            return null;
        }

        List<DenunciaResponseDto> list = new ArrayList<DenunciaResponseDto>( denuncia.size() );
        for ( Denuncia denuncia1 : denuncia ) {
            list.add( toResponseDto( denuncia1, cloudinaryService ) );
        }

        return list;
    }
}
