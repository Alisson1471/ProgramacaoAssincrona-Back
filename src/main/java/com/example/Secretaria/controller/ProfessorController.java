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

    @GetMapping("/login")
    public ResponseEntity<ProfessorResponse> login(@RequestParam String usuario, @RequestParam String senha) {
        return ResponseEntity.status(200).body(professorService.login(usuario, senha));
    }

    @PostMapping("/nota")
    public ResponseEntity<NotaResponse> lancarNota(@RequestBody NotaRequest request,
                                                   @RequestParam(name = "professor_id") int professorId) {
        return ResponseEntity.status(201).body(professorService.lancarNota(request, professorId));
    }

}
