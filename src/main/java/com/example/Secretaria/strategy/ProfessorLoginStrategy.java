package com.example.Secretaria.strategy;

import com.example.Secretaria.dto.request.LoginRequest;
import org.springframework.stereotype.Component;

@Component
public class ProfessorLoginStrategy implements LoginStrategy {

    @Override
    public String login(LoginRequest loginRequest) {
        return "Professor bolado!";
    }

    @Override
    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("Professor");
    }
}
