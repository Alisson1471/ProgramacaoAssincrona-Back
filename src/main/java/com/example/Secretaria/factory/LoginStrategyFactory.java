package com.example.Secretaria.factory;

import com.example.Secretaria.strategy.LoginStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LoginStrategyFactory {

    private final List<LoginStrategy> strategies;

    public LoginStrategy getStrategy(String userType) {
        return strategies.stream()
                .filter(s -> s.supports(userType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo inválido"));
    }

}
