package com.example.Secretaria.controller;

import com.example.Secretaria.dto.request.ObservacaoRequest;
import com.example.Secretaria.dto.response.ObservacaoResponse;
import com.example.Secretaria.service.ObservacaoService;
import com.example.Secretaria.controller.docs.ObservacaoControllerDocs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/observacao")
public class ObservacaoController implements ObservacaoControllerDocs {

    private final ObservacaoService observacaoService;

    @PostMapping
    public ResponseEntity<ObservacaoResponse> create(@RequestBody ObservacaoRequest request) {
        return ResponseEntity.status(201).body(observacaoService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ObservacaoResponse>> get(@RequestParam(value = "aluno_id", required = false) Integer alunoId,
                                               @RequestParam(value = "professor_id", required = false) Integer professorId) {
        return ResponseEntity.status(200).body(observacaoService.get(alunoId, professorId));
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotal() {
        return ResponseEntity.status(200).body(observacaoService.getTotal());
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        observacaoService.delete(id);
        return ResponseEntity.status(200).body("Observação deletada com sucesso!");
    }

}