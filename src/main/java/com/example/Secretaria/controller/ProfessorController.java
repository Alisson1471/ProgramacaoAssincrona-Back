package com.example.Secretaria.controller;

import com.example.Secretaria.dto.request.NotaRequest;
import com.example.Secretaria.dto.response.NotaResponse;
import com.example.Secretaria.dto.response.ProfessorResponse;
import com.example.Secretaria.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/professor")
@RestController
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping("/nota")
    public ResponseEntity<NotaResponse> lancarNota(@RequestBody NotaRequest request,
                                                   @RequestParam(name = "professor_id") int professorId) {
        return ResponseEntity.status(201).body(professorService.lancarNota(request, professorId));
    }

}
