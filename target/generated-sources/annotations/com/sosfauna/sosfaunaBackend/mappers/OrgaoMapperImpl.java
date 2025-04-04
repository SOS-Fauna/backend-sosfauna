package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.OrgaoDto;
import com.sosfauna.sosfaunaBackend.model.entity.Orgao;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-04T03:37:09-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.3 (Eclipse Adoptium)"
)
@Component
public class OrgaoMapperImpl implements OrgaoMapper {

    @Override
    public Orgao toOrgao(OrgaoDto orgaoDto) {
        if ( orgaoDto == null ) {
            return null;
        }

        Orgao orgao = new Orgao();

        return orgao;
    }

    @Override
    public OrgaoDto toOrgaoDto(Orgao orgao) {
        if ( orgao == null ) {
            return null;
        }

        String nome = null;
        String cnpj = null;
        String descricao = null;
        String telefone = null;
        String redeSocial = null;
        String rua = null;
        String numero = null;
        String bairro = null;
        String cidade = null;
        String cep = null;
        boolean acesso = false;
        LocalDate dataCadastro = null;

        OrgaoDto orgaoDto = new OrgaoDto( nome, cnpj, descricao, telefone, redeSocial, rua, numero, bairro, cidade, cep, acesso, dataCadastro );

        return orgaoDto;
    }
}
