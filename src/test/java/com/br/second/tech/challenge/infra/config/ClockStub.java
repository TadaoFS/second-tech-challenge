package com.br.second.tech.challenge.infra.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockStub {

    public static final LocalDateTime DATA_FIXA =
            LocalDateTime.of(2025, 10, 12, 10, 30, 0);
    public static final ZoneId ZONA = ZoneId.of("America/Sao_Paulo");
    public static final Instant INSTANT = DATA_FIXA.atZone(ZONA).toInstant();
}
