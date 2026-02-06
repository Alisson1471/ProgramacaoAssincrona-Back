package com.example.Secretaria.controller;

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

}
