package com.example.Secretaria.service;

import com.example.Secretaria.adapter.AdminAdapter;
import com.example.Secretaria.model.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminAdapter adminAdapter;

    public Admin buscarPorId(Integer id) {
        return adminAdapter.findById(id);
    }

}