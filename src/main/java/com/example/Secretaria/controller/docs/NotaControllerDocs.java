package com.example.Secretaria.controller.docs;

import com.example.Secretaria.dto.request.NotaRequest;
import com.example.Secretaria.dto.response.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Notas", description = "Endpoints responsáveis pelo gerenciamento de notas dos alunos")
public interface NotaControllerDocs {

    @Operation(
            summary = "Buscar notas de um aluno",
            description = "Retorna todas as notas associadas a um aluno específico."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Notas retornadas com sucesso",
                    content = @Content(schema = @Schema(implementation = NotaResponseDTO.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aluno não encontrado",
                    content = @Content
            )
    })
    ResponseEntity<List<NotaResponseDTO>> getNotas(
            @Parameter(description = "ID do aluno", required = true)
            @RequestParam(name = "aluno_id") int alunoId
    );


    @Operation(
            summary = "Criar nota",
            description = "Cria uma nova nota para um aluno em uma disciplina."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Nota criada com sucesso",
                    content = @Content(schema = @Schema(implementation = NotaResponse.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos",
                    content = @Content
            )
    })
    ResponseEntity<NotaResponse> create(
            @RequestBody NotaRequest request,

            @Parameter(description = "ID do professor que está registrando a nota", required = true)
            @RequestParam(name = "professor_id") int professorId
    );


    @Operation(
            summary = "Atualizar nota",
            description = "Atualiza o valor de uma nota existente."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Nota atualizada com sucesso",
                    content = @Content(schema = @Schema(implementation = NotaResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Nota não encontrada",
                    content = @Content
            )
    })
    ResponseEntity<NotaResponse> update(
            @Parameter(description = "ID da nota", required = true)
            @RequestParam(name = "nota_id") int notaId,

            @Parameter(description = "Novo valor da nota", required = true, example = "8.5")
            @RequestParam BigDecimal valor
    );


    @Operation(
            summary = "Notas por disciplina",
            description = "Retorna todas as notas de alunos em uma disciplina específica."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Notas encontradas",
                    content = @Content(schema = @Schema(implementation = NotaAlunoReponseDTO.class))
            )
    })
    ResponseEntity<List<NotaAlunoReponseDTO>> getGradesByDiscipline(
            @Parameter(description = "Nome da disciplina", example = "Matemática", required = true)
            @RequestParam("disciplina") String discipline
    );


    @Operation(
            summary = "Status das disciplinas",
            description = "Retorna o status geral das disciplinas (ex: aprovado, reprovado, etc)."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Status retornado com sucesso",
                    content = @Content(schema = @Schema(implementation = StatusDisciplineResponse.class))
            )
    })
    ResponseEntity<List<StatusDisciplineResponse>> statusByDiscipline();


    @Operation(
            summary = "Disciplinas por aluno",
            description = "Retorna as disciplinas e respectivas notas de um aluno."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Dados retornados com sucesso",
                    content = @Content(schema = @Schema(implementation = NotaDisciplinaResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aluno não encontrado",
                    content = @Content
            )
    })
    ResponseEntity<List<NotaDisciplinaResponse>> statusByDisciplineByAluno(
            @Parameter(description = "ID do aluno", required = true)
            @RequestParam("aluno_id") Integer alunoId
    );

}