package com.sosfauna.sosfaunaBackend.repository;
import com.sosfauna.sosfaunaBackend.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    Optional<Usuario> findByCpf(String cpf);
    Optional<Usuario> findByEmail(String email);

}
