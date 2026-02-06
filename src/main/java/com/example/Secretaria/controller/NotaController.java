package com.example.Secretaria.controller;

import com.example.Secretaria.dto.request.NotaRequest;
import com.example.Secretaria.dto.response.NotaResponse;
import com.example.Secretaria.dto.response.NotaResponseDTO;
import com.example.Secretaria.dto.response.StatusDisciplineResponse;
import com.example.Secretaria.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/nota")
@RestController
public class NotaController {

    private final NotaService notaService;

    @GetMapping
    public ResponseEntity<List<NotaResponseDTO>> getNotas(@RequestParam(name = "aluno_id") int alunoId) {
        return ResponseEntity.status(200).body(notaService.getNotas(alunoId));
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

    @GetMapping("/disciplina")
    public ResponseEntity<List<StatusDisciplineResponse>> statusByDiscipline() {
        return ResponseEntity.status(200).body(notaService.statusByDiscipline());
    }

}
