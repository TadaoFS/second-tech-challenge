package com.br.second.tech.challenge.core.domain;

import org.mockito.Mock;

import java.time.Clock;

public abstract class BaseTestWithClock {

    @Mock
    protected Clock clock;
}
