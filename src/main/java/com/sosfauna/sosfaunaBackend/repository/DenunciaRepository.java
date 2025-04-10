package com.sosfauna.sosfaunaBackend.repository;

import com.sosfauna.sosfaunaBackend.model.entity.Denuncia;
import com.sosfauna.sosfaunaBackend.model.entity.Orgao;
import com.sosfauna.sosfaunaBackend.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, String> {
    List<Denuncia> findByUsuarioId(String idUsuario);
    List<Denuncia> findByOrgaoIsNull();
    List<Denuncia> findByOrgaoIsNotNull();
    Optional<Denuncia> findByProtocolo(String protocolo);




}
