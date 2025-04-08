package com.sosfauna.sosfaunaBackend.repository;

import com.sosfauna.sosfaunaBackend.model.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Optional<Animal> findById(Long id);
}
