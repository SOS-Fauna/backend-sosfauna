package com.sosfauna.sosfaunaBackend.service;



import com.sosfauna.sosfaunaBackend.mappers.DenunciaMapper;
import com.sosfauna.sosfaunaBackend.mappers.ProtocoloMapper;
import com.sosfauna.sosfaunaBackend.model.dto.DenunciaRequestDto;
import com.sosfauna.sosfaunaBackend.model.dto.DenunciaResponseDto;
import com.sosfauna.sosfaunaBackend.model.dto.ProtocoloResponse;
import com.sosfauna.sosfaunaBackend.model.entity.Denuncia;
import com.sosfauna.sosfaunaBackend.model.entity.Orgao;
import com.sosfauna.sosfaunaBackend.model.entity.Usuario;
import com.sosfauna.sosfaunaBackend.model.enumerated.StatusDenuncia;
import com.sosfauna.sosfaunaBackend.repository.DenunciaRepository;
import com.sosfauna.sosfaunaBackend.repository.OrgaoRepository;
import com.sosfauna.sosfaunaBackend.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;
import java.util.List;


@Service
public class DenunciaService {
    private final DenunciaRepository denunciaRepository;
    private final OrgaoRepository orgaoRepository;
    private final CloudinaryService cloudinaryService;
    private final DenunciaMapper denunciaMapper;
    private final UsuarioRepository usuarioRepository;
    private final GerarProtocoloService gerarProtocoloService;
    private final ProtocoloMapper protocoloMapper;

    public DenunciaService(
            DenunciaRepository denunciaRepository,
            OrgaoRepository orgaoRepository,
            CloudinaryService cloudinaryService,
            DenunciaMapper denunciaMapper,
            UsuarioRepository usuarioRepository,
            GerarProtocoloService gerarProtocoloService,
            ProtocoloMapper protocoloMapper
    ) {
        this.denunciaRepository = denunciaRepository;
        this.orgaoRepository = orgaoRepository;
        this.cloudinaryService = cloudinaryService;
        this.denunciaMapper = denunciaMapper;
        this.usuarioRepository = usuarioRepository;
        this.gerarProtocoloService = gerarProtocoloService;
        this.protocoloMapper = protocoloMapper;
    }

    private String getEmailLogado() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private Usuario getUsuarioLogado() {
        return usuarioRepository.findByEmail(getEmailLogado())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    private Orgao getOrgaoLogado() {
        return orgaoRepository.findByEmail(getEmailLogado())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Órgão não encontrado"));
    }


    public DenunciaResponseDto criar(DenunciaRequestDto dto) {
        Usuario usuario = getUsuarioLogado();
        String publicId;
        try {
            publicId = cloudinaryService.subirImagem(dto.file());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao fazer upload da imagem", e);
        }

        Denuncia denuncia = denunciaMapper.transicao(dto, new Denuncia());
        denuncia.setUsuario(usuario);
        denuncia.setPublicId(publicId);
        denuncia.setProtocolo(gerarProtocoloService.gerar());

        return denunciaMapper.toResponseDto(denunciaRepository.save(denuncia), cloudinaryService);
    }

    public List<DenunciaResponseDto> listarMinhasDenuncias() {
        Usuario usuario = getUsuarioLogado();
        return denunciaMapper.toResponseDto(denunciaRepository.findByUsuarioId(usuario.getId()), cloudinaryService);
    }

    public List<DenunciaResponseDto> listarPendentes() {
        return denunciaMapper.toResponseDto(denunciaRepository.findByOrgaoIsNull(), cloudinaryService);
    }

    public List<DenunciaResponseDto> listarAceitas() {
        return denunciaMapper.toResponseDto(denunciaRepository.findByOrgaoIsNotNull(), cloudinaryService);
    }

    public void aceitarDenuncia(String idDenuncia) {
        Orgao orgao = getOrgaoLogado();
        Denuncia denuncia = denunciaRepository.findById(idDenuncia)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Denúncia não encontrada"));

        denuncia.setOrgao(orgao);
        denuncia.setStatusDenuncia(StatusDenuncia.ANALISE);
        denunciaRepository.save(denuncia);
    }

    public ProtocoloResponse buscarProtocolo(String protocolo) {

        StatusDenuncia statusDenuncia;
        Denuncia denuncia = denunciaRepository.findByProtocolo(protocolo.toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException("Denúncia não encontrada com esse protocolo"));

        return protocoloMapper.toResponseDto(denuncia);
    }


    public void concluirDenuncia(String idDenuncia) {
        Denuncia denuncia = denunciaRepository.findById(idDenuncia)
                .orElseThrow(() -> new IllegalArgumentException("Denúncia não encontrada"));

        if (denuncia.getStatusDenuncia() != StatusDenuncia.ANALISE) {
            throw new IllegalStateException("Só é possível concluir uma denúncia que está em análise");
        }

        denuncia.setStatusDenuncia(StatusDenuncia.CONCLUIDA);
        denunciaRepository.save(denuncia);
    }

    public void deletarDenuncia(String idDenuncia){
        Denuncia denuncia = denunciaRepository.findById(idDenuncia).orElseThrow(() -> new IllegalArgumentException("Denúncia não encontrada"));
        denunciaRepository.delete(denuncia);
    }





}





