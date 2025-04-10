package com.sosfauna.sosfaunaBackend.mappers;

import com.sosfauna.sosfaunaBackend.model.dto.OrgaoDto;
import com.sosfauna.sosfaunaBackend.model.entity.Orgao;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-09T20:01:38-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class OrgaoMapperImpl implements OrgaoMapper {

    @Override
    public Orgao toOrgao(OrgaoDto orgaoDto) {
        if ( orgaoDto == null ) {
            return null;
        }

        Orgao orgao = new Orgao();

        orgao.setEmail( orgaoDto.email() );
        orgao.setNome( orgaoDto.nome() );
        orgao.setCnpj( orgaoDto.cnpj() );
        orgao.setDescricao( orgaoDto.descricao() );
        orgao.setTelefone( orgaoDto.telefone() );
        orgao.setRedeSocial( orgaoDto.redeSocial() );
        orgao.setRua( orgaoDto.rua() );
        orgao.setNumero( orgaoDto.numero() );
        orgao.setBairro( orgaoDto.bairro() );
        orgao.setCidade( orgaoDto.cidade() );
        orgao.setCep( orgaoDto.cep() );
        orgao.setAcesso( orgaoDto.acesso() );
        orgao.setDataCadastro( orgaoDto.dataCadastro() );

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
        String email = null;

        nome = orgao.getNome();
        cnpj = orgao.getCnpj();
        descricao = orgao.getDescricao();
        telefone = orgao.getTelefone();
        redeSocial = orgao.getRedeSocial();
        rua = orgao.getRua();
        numero = orgao.getNumero();
        bairro = orgao.getBairro();
        cidade = orgao.getCidade();
        cep = orgao.getCep();
        acesso = orgao.isAcesso();
        dataCadastro = orgao.getDataCadastro();
        email = orgao.getEmail();

        OrgaoDto orgaoDto = new OrgaoDto( nome, cnpj, descricao, telefone, redeSocial, rua, numero, bairro, cidade, cep, acesso, dataCadastro, email );

        return orgaoDto;
    }
}
