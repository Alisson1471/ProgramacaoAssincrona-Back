package com.example.Secretaria.controller;

import com.example.Secretaria.controller.docs.AlunoControllerDocs;
import com.example.Secretaria.dto.request.AlunoAtualizarRequest;
import com.example.Secretaria.dto.request.AlunoRequest;
import com.example.Secretaria.model.Aluno;
import com.example.Secretaria.service.AlunoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Aluno", description = "Operações relacionadas aos Alunos")
@RequestMapping("/aluno")
@RestController
public class AlunoController implements AlunoControllerDocs {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/listar")
    public List<Aluno> listarAluno() {
        return alunoService.listar();
    }

    @GetMapping("/listarMatricula")
    public ResponseEntity<Optional<Aluno>> selecionarPeloId(String matricula) {
        return ResponseEntity.ok(alunoService.buscarPorMatricula(matricula));
    }
    @GetMapping("/listarDesativo")
    public ResponseEntity<List<Aluno>> selecionarDesativo() {
        return ResponseEntity.ok(alunoService.buscarPorDesativado());
    }

    @GetMapping("/listarAtivo")
    public ResponseEntity<List<Aluno>> selecionarAtivo() {
        return ResponseEntity.ok(alunoService.buscarPorAtivo());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarAluno(@Valid AlunoRequest alunoRequest) {
        alunoService.salvar(alunoRequest);
        return ResponseEntity.ok("Aluno adicionado com sucesso.");
    }

    @PatchMapping
    public ResponseEntity<String> updateActiveAluno(int alunoId) {
        alunoService.updateActive(alunoId);
        return ResponseEntity.ok("Aluno atualizado com sucesso.");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarAluno(@PathVariable Integer id,
                                                   @Validated @RequestBody AlunoAtualizarRequest alunoAtualizado) {
        alunoService.atualizarAluno(id, alunoAtualizado);
        return ResponseEntity.ok("Aluno atualizado com sucesso!");
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarAluno(Integer id) {
        alunoService.deletar(id);
        return ResponseEntity.ok("Aluno deletado com sucesso.");
    }
}
