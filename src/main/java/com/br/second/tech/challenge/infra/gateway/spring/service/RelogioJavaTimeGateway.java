package com.br.second.tech.challenge.infra.gateway.spring.service;

import com.br.second.tech.challenge.core.gateway.RelogioGateway;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class RelogioJavaTimeGateway implements RelogioGateway {

    private final Clock clock;

    public RelogioJavaTimeGateway(Clock clock) {
        this.clock = clock;
    }

    @Override
    public LocalDateTime registrarTempo() {
        return LocalDateTime.now(clock);
    }
}
