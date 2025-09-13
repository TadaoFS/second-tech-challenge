package com.br.second.tech.challenge.infra.controller;

import com.br.second.tech.challenge.app.dto.RestauranteDTO;
import com.br.second.tech.challenge.app.mapper.RestauranteMapper;
import com.br.second.tech.challenge.core.usecase.RestauranteUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/restaurante")
public class RestauranteController {

    RestauranteMapper mapper;
    RestauranteUseCase useCase;

    public RestauranteController(RestauranteMapper mapper, RestauranteUseCase useCase) {
        this.mapper = mapper;
        this.useCase = useCase;
    }

    @GetMapping(value="/{id}", produces = "application/json")
    public RestauranteDTO getRestaurante(@PathVariable long id) {
        return null;
    }

    @PostMapping(produces = "application/json")
    public String postRestaurante() {
        return null;
    }

    @PutMapping(value="/{id}", produces = "application/json")
    public RestauranteDTO putRestaurante(@PathVariable long id, @RequestBody RestauranteDTO restauranteDto) {
        mapper.toEntity(restauranteDto);
        return null;
    }

    @DeleteMapping(value="/{id}", produces = "application/json")
    public String deleteRestaurante(@PathVariable long id) {
        return null;
    }
}
