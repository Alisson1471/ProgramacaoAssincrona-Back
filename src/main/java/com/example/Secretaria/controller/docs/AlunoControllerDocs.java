package com.example.Secretaria.controller.docs;

import com.example.Secretaria.dto.request.AlunoAtualizarRequest;
import com.example.Secretaria.dto.request.AlunoRequest;
import com.example.Secretaria.model.Aluno;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AlunoControllerDocs {

    @Operation(summary = "Lista todos os alunos cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso")
    })
    List<Aluno> listarAluno();

    @Operation(summary = "Busca um aluno pela matrícula")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    ResponseEntity<Optional<Aluno>> selecionarPeloId(String matricula);

    @Operation(summary = "Lista todos os alunos desativados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de alunos desativados retornada com sucesso")
    })
    ResponseEntity<List<Aluno>> selecionarDesativo();

    @Operation(summary = "Lista todos os alunos ativos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de alunos ativos retornada com sucesso")
    })
    ResponseEntity<List<Aluno>> selecionarAtivo();

    @Operation(summary = "Adiciona um novo aluno")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aluno adicionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<String> adicionarAluno(@Valid AlunoRequest alunoRequest);

    @Operation(summary = "Ativa ou desativa um aluno")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Status do aluno atualizado"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    ResponseEntity<String> updateActiveAluno(int alunoId);

    @Operation(summary = "Atualiza os dados de um aluno")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    ResponseEntity<String> atualizarAluno(Integer id, AlunoAtualizarRequest alunoAtualizado);

    @Operation(summary = "Remove um aluno do sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aluno deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    ResponseEntity<String> deletarAluno(Integer id);
}