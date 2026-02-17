package com.example.Secretaria.controller;

import com.example.Secretaria.dto.request.ProfessorRequest;
import com.example.Secretaria.dto.response.ProfessorResponse;
import com.example.Secretaria.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/professor")
@RestController
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    public ResponseEntity<ProfessorResponse> create(@RequestBody ProfessorRequest request) {
        return ResponseEntity.status(201).body(professorService.createProfessor(request));
    }

}
