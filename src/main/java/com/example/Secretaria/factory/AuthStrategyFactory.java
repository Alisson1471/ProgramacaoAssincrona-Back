package com.example.Secretaria.factory;

import com.example.Secretaria.strategy.AuthStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AuthStrategyFactory {

    private final List<AuthStrategy> strategies;

    public AuthStrategy getStrategy(String userType) {
        return strategies.stream()
                .filter(s -> s.supports(userType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo inválido"));
    }

}
