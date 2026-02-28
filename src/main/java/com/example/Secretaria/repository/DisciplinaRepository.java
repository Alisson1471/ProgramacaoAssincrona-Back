package com.example.Secretaria.repository;


import com.example.Secretaria.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

    Optional<Disciplina> findByNome(String nome);
}
