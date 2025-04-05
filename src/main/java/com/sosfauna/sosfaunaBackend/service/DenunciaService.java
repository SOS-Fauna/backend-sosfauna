package com.sosfauna.sosfaunaBackend.service;

import com.sosfauna.sosfaunaBackend.mappers.DenunciaMapper;
import com.sosfauna.sosfaunaBackend.repository.DenunciaRepository;
import com.sosfauna.sosfaunaBackend.repository.OrgaoRepository;
import org.springframework.stereotype.Service;

@Service
public class DenunciaService {
    private final DenunciaRepository denunciaRepository;
    private final OrgaoRepository orgaoRepository;
    private final CloudinaryService cloudinaryService;
    private final DenunciaMapper denunciaMapper;
    //private final UsuarioRepository usuarioRepository;

    public DenunciaService(
            DenunciaRepository denunciaRepository,
            OrgaoRepository orgaoRepository,
            CloudinaryService cloudinaryService,
            DenunciaMapper denunciaMapper
            //UsuarioRepository usuarioRepository
    ) {
        this.denunciaRepository = denunciaRepository;
        this.orgaoRepository = orgaoRepository;
        this.cloudinaryService = cloudinaryService;
        this.denunciaMapper = denunciaMapper;
       //this.usuarioRepository = usuarioRepository
    }

}
