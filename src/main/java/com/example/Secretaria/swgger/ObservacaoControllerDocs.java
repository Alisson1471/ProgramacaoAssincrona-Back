package com.example.Secretaria.swgger;

import com.example.Secretaria.dto.request.ObservacaoRequest;
import com.example.Secretaria.dto.response.ObservacaoResponse;
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

import java.util.List;

@Tag(name = "Observações", description = "Endpoints responsáveis pelo gerenciamento de observações de alunos")
public interface ObservacaoControllerDocs {

    @Operation(
            summary = "Criar observação",
            description = "Cria uma nova observação associada a um aluno e professor."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Observação criada com sucesso",
                    content = @Content(schema = @Schema(implementation = ObservacaoResponse.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos",
                    content = @Content
            )
    })
    ResponseEntity<ObservacaoResponse> create(@RequestBody ObservacaoRequest request);


    @Operation(
            summary = "Buscar observações",
            description = "Retorna observações podendo filtrar por aluno ou professor."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Observações encontradas",
                    content = @Content(schema = @Schema(implementation = ObservacaoResponse.class))
            )
    })
    ResponseEntity<List<ObservacaoResponse>> get(
            @Parameter(description = "ID do aluno para filtrar observações")
            @RequestParam(value = "aluno_id", required = false) Integer alunoId,

            @Parameter(description = "ID do professor para filtrar observações")
            @RequestParam(value = "professor_id", required = false) Integer professorId
    );


    @Operation(
            summary = "Total de observações",
            description = "Retorna a quantidade total de observações cadastradas."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Total retornado com sucesso",
                    content = @Content(schema = @Schema(implementation = Long.class))
            )
    })
    ResponseEntity<Long> getTotal();


    @Operation(
            summary = "Deletar observação",
            description = "Remove uma observação pelo seu ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Observação deletada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Observação não encontrada",
                    content = @Content
            )
    })
    ResponseEntity<String> delete(
            @Parameter(description = "ID da observação que será deletada", required = true)
            @RequestParam Integer id
    );

}