package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.ProtocoloResponse;
import com.sosfauna.sosfaunaBackend.model.entity.Denuncia;
import com.sosfauna.sosfaunaBackend.model.entity.StatusDenuncia;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-10T01:16:05-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class ProtocoloMapperImpl implements ProtocoloMapper {

    @Override
    public ProtocoloResponse toResponseDto(Denuncia denuncia) {
        if ( denuncia == null ) {
            return null;
        }

        String protocolo = denuncia.getProtocolo();
        StatusDenuncia statusDenuncia = denuncia.getStatusDenuncia();
        String telefoneOrgao = denuncia.getOrgao().getId();
        String redeSocialOrgao = denuncia.getOrgao().getRedeSocial();
        String nomeOrgao = denuncia.getOrgao().getNome();

        ProtocoloResponse protocoloResponse = new ProtocoloResponse( protocolo, statusDenuncia, telefoneOrgao, redeSocialOrgao, nomeOrgao );

        return protocoloResponse;
    }
}
