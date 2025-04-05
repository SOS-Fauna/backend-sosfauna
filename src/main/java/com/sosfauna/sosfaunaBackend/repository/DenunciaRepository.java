package com.sosfauna.sosfaunaBackend.repository;

import com.sosfauna.sosfaunaBackend.model.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, String> {
}
