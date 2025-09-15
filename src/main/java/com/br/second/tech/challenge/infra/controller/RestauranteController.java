package com.br.second.tech.challenge.infra.controller;

import com.br.second.tech.challenge.core.usecase.RestauranteUseCase;
import com.br.second.tech.challenge.infra.controller.dto.RestauranteDTO;
import com.br.second.tech.challenge.infra.controller.mapper.RestauranteMapper;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/restaurante")
public class RestauranteController {

    RestauranteMapper restauranteMapper;
    RestauranteUseCase restauranteUseCase;

    public RestauranteController(RestauranteMapper restauranteMapper, RestauranteUseCase restauranteUseCase) {
        this.restauranteMapper = restauranteMapper;
        this.restauranteUseCase = restauranteUseCase;
    }

    @GetMapping(value="/{id}", produces = "application/json")
    public RestauranteDTO getRestaurante(@PathVariable long id) {
        RestauranteEntity restaurante = this.restauranteUseCase.buscarRestaurante(id);
        if (restaurante == null) {
            return null;
        }
        return this.restauranteMapper.toDTO(restaurante);
    }

    @PostMapping(produces = "application/json")
    public String postRestaurante(@RequestBody RestauranteDTO restauranteDto) {
        return this.restauranteUseCase.criarRestaurante(this.restauranteMapper.toEntity(restauranteDto));
    }

    @PutMapping(value="/{id}", produces = "application/json")
    public String putRestaurante(@PathVariable long id, @RequestBody RestauranteDTO restauranteDto) {
        return this.restauranteUseCase.editarRestaurante(restauranteMapper.toEntity(restauranteDto));
    }

    @DeleteMapping(value="/{id}", produces = "application/json")
    public String deleteRestaurante(@PathVariable long id) {
        return this.restauranteUseCase.deletarRestaurante(id);
    }
}
