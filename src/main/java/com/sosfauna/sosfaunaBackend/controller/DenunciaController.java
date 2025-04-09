package com.sosfauna.sosfaunaBackend.controller;

import com.sosfauna.sosfaunaBackend.model.dto.DenunciaRequestDto;
import com.sosfauna.sosfaunaBackend.model.dto.DenunciaResponseDto;
import com.sosfauna.sosfaunaBackend.service.CloudinaryService;
import com.sosfauna.sosfaunaBackend.service.DenunciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/denuncias")
public class DenunciaController {
    @Autowired
    private DenunciaService denunciaService;
    private CloudinaryService cloudinaryService;

    public DenunciaController(DenunciaService denunciaService, CloudinaryService cloudinaryService){
        this.denunciaService = denunciaService;
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("criar")
    public ResponseEntity<DenunciaResponseDto> criar(@ModelAttribute @Valid DenunciaRequestDto dto) {
        DenunciaResponseDto response = denunciaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/minhas")
    public ResponseEntity<List<DenunciaResponseDto>> listarMinhas() {
        return ResponseEntity.ok(denunciaService.listarMinhasDenuncias());
    }


    @GetMapping("/pendentes")
    public ResponseEntity<List<DenunciaResponseDto>> listarPendentes() {
        return ResponseEntity.ok(denunciaService.listarPendentes());
    }


    @GetMapping("/aceitas")
    public ResponseEntity<List<DenunciaResponseDto>> listarAceitas() {
        return ResponseEntity.ok(denunciaService.listarAceitas());
    }


    @PatchMapping("/{id}/aceitar")
    public ResponseEntity<Void> aceitarDenuncia(@PathVariable("id") String idDenuncia) {
        denunciaService.aceitarDenuncia(idDenuncia);
        return ResponseEntity.noContent().build();
    }

}
