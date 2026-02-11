package com.example.Secretaria.repository;

import com.example.Secretaria.model.Observacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObservacaoRepository extends JpaRepository<Observacao, Integer> {

    Optional<List<Observacao>> findByAluno_Id(Integer id);
    Optional<List<Observacao>> findByProfessor_Id(Integer id);
    Optional<List<Observacao>> findByAluno_IdAndProfessor_Id(Integer alunoId, Integer professorId);
}
