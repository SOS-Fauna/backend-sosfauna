package com.sosfauna.sosfaunaBackend.service;

import com.sosfauna.sosfaunaBackend.mappers.DenunciaMappers;
import com.sosfauna.sosfaunaBackend.repository.DenunciaRepository;
import com.sosfauna.sosfaunaBackend.repository.OrgaoRepository;
import org.springframework.stereotype.Service;

@Service
public class DenunciaService {
    private final DenunciaRepository denunciaRepository;
    private final OrgaoRepository orgaoRepository;
    private final CloudinaryService cloudinaryService;
    private final DenunciaMappers denunciaMappers;
    //private final UsuarioRepository usuarioRepository;

    public DenunciaService(
            DenunciaRepository denunciaRepository,
            OrgaoRepository orgaoRepository,
            CloudinaryService cloudinaryService,
            DenunciaMappers denunciaMappers
            //UsuarioRepository usuarioRepository
    ) {
        this.denunciaRepository = denunciaRepository;
        this.orgaoRepository = orgaoRepository;
        this.cloudinaryService = cloudinaryService;
        this.denunciaMappers = denunciaMappers;
    }

}
