package com.example.Secretaria.controller;

import com.example.Secretaria.dto.request.NotaRequest;
import com.example.Secretaria.dto.response.*;
import com.example.Secretaria.service.NotaService;
import com.example.Secretaria.swgger.NotaControllerDocs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/nota")
@RestController
public class NotaController implements NotaControllerDocs {

    private final NotaService notaService;

    @GetMapping
    public ResponseEntity<List<NotaResponseDTO>> getNotas(@RequestParam(name = "aluno_id") int alunoId) {
        return ResponseEntity.status(200).body(notaService.getGrades(alunoId));
    }

    @PostMapping
    public ResponseEntity<NotaResponse> create(@RequestBody NotaRequest request,
                                                   @RequestParam(name = "professor_id") int professorId) {
        return ResponseEntity.status(201).body(notaService.create(request, professorId));
    }

    @PatchMapping
    public ResponseEntity<NotaResponse> update(@RequestParam(name = "nota_id") int notaId,
                                                   @RequestParam BigDecimal valor) {
        return ResponseEntity.status(201).body(notaService.update(notaId, valor));
    }

    @GetMapping("/notasDisciplina")
    public ResponseEntity<List<NotaAlunoReponseDTO>> getGradesByDiscipline(@RequestParam("disciplina") String discipline) {
        return ResponseEntity.status(200).body(notaService.getGradesByDiscipline(discipline));
    }

    @GetMapping("/statusDisciplina")
    public ResponseEntity<List<StatusDisciplineResponse>> statusByDiscipline() {
        return ResponseEntity.status(200).body(notaService.statusByDiscipline());
    }

    @GetMapping("/discplinaByAluno")
    public ResponseEntity<List<NotaDisciplinaResponse>> statusByDisciplineByAluno(@RequestParam("aluno_id") Integer alunoId) {
        return ResponseEntity.status(200).body(notaService.statusByDisciplinaByAluno(alunoId));
    }

}
