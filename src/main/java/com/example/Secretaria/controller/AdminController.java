package com.example.Secretaria.controller;

import com.example.Secretaria.model.Admin;
import com.example.Secretaria.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestParam String cpf,
                                       @RequestParam String senha) {

        var admin = adminService.login(cpf, senha);
        return ResponseEntity.ok(admin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> buscarPorId(@PathVariable Integer id) {

        var admin = adminService.buscarPorId(id);
        return ResponseEntity.ok(admin);
    }
}
