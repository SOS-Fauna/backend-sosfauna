package com.sosfauna.sosfaunaBackend.repository;


import com.sosfauna.sosfaunaBackend.model.entity.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, String> {
    Optional<Orgao> findByCnpj(String cnpj);
    Optional<Orgao> findByEmail(String email);
}
