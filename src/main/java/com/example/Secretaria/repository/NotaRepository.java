package com.example.Secretaria.repository;

import com.example.Secretaria.dto.response.NotaDisciplinaAlunoResponse;
import com.example.Secretaria.dto.response.NotaResponseDTO;
import com.example.Secretaria.dto.response.StatusDisciplineResponse;
import com.example.Secretaria.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {

    List<Nota> findByAluno_IdAndDisciplina_Id(int aluno_id, int disciplina_id);

    @Query(value = "SELECT * FROM fn_status_disciplinas()", nativeQuery = true)
    List<StatusDisciplineResponse> findStatusDiscipline();

    @Query(value = """
        SELECT n.titulo,
               d.nome AS disciplina,
               n.valor
        FROM nota n
        JOIN disciplina d ON d.id = n.disciplina_id
        WHERE n.aluno_id = :aluno_id
        """,
            nativeQuery = true)
    List<NotaResponseDTO> findByAluno_Id(@Param("aluno_id") int aluno_id);

    @Query(value = "SELECT * FROM fn_status_disciplina_by_aluno(:aluno_id)", nativeQuery = true)
    List<NotaDisciplinaAlunoResponse> findStatusDisciplinaByAlunoId(int aluno_id);
}
