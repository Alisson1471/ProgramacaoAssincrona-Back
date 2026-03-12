package com.example.Secretaria.controller;

import com.example.Secretaria.controller.docs.ProfessorControllerDocs;
import com.example.Secretaria.dto.request.ProfessorRequest;
import com.example.Secretaria.dto.response.ProfessorResponse;
import com.example.Secretaria.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/professor")
@RestController
@RequiredArgsConstructor
public class ProfessorController implements ProfessorControllerDocs {

    private final ProfessorService professorService;

    @PostMapping()
    public ResponseEntity<ProfessorResponse> create(@RequestBody ProfessorRequest request) {
        return ResponseEntity.status(201).body(professorService.createProfessor(request));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProfessorResponse>> getAll() {
        return ResponseEntity.status(200).body(professorService.list());
    }

}
