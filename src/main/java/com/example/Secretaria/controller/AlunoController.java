package com.example.Secretaria.controller;

import com.example.Secretaria.dto.request.AlunoRequest;
import com.example.Secretaria.model.Aluno;
import com.example.Secretaria.service.AlunoService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/aluno")
@RestController
public class AlunoController {
    private final AlunoService alunoService;
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    @GetMapping("/listar")
    public List<Aluno> listarAluno() {
        return alunoService.listar();
    }
    @GetMapping("listarMatricula")
    public ResponseEntity<Optional<Aluno>> selecionarPeloId(String matricula) {
        return ResponseEntity.ok(alunoService.buscarPorMatricula(matricula));
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarAluno(@Valid AlunoRequest alunoRequest) {
        Aluno aluno = alunoService.salvar(alunoRequest);
        return ResponseEntity.ok("Aluno adicionado com sucesso.");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Integer id,
                                                   @Validated @RequestBody AlunoRequest alunoAtualizado) {
        alunoService.atualizarAluno(id, alunoAtualizado);
        return ResponseEntity.ok("Produto atualizado com sucesso!");
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarAluno(Integer id) {
        alunoService.deletar(id);
        return ResponseEntity.ok("Aluno deletado com sucesso.");
    }
}
