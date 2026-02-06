package com.example.Secretaria.repository;

import com.example.Secretaria.dto.response.NotaResponseDTO;
import com.example.Secretaria.dto.response.StatusDisciplineResponse;
import com.example.Secretaria.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {

    List<Nota> findByAluno_IdAndDisciplina_Id(int aluno_id, int disciplina_id);

    @Query(value = "SELECT * FROM fn_status_disciplinas()", nativeQuery = true)
    List<StatusDisciplineResponse> findStatusDiscipline();

    @Query(value = "SELECT titulo, valor FROM nota WHERE aluno_id = :aluno_id", nativeQuery = true)
    List<NotaResponseDTO> findByAluno_Id(int aluno_id);

}
