package com.br.second.tech.challenge.app.controller;

import com.br.second.tech.challenge.app.domain.entities.DiaFuncionamento;
import com.br.second.tech.challenge.app.dto.DiaFuncionamentoDTO;
import com.br.second.tech.challenge.app.dto.RestauranteDTO;
import com.br.second.tech.challenge.app.mapper.DiaFuncionamentoMapper;
import com.br.second.tech.challenge.app.mapper.RestauranteMapper;
import com.br.second.tech.challenge.app.usecase.DiasFuncionamentoUseCase;
import com.br.second.tech.challenge.app.usecase.RestauranteUseCase;
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
        return this.restauranteMapper.toDTO(this.restauranteUseCase.buscarRestaurante(id));
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
