package com.br.second.tech.challenge.infra.controller;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.domain.SemanaFuncionamento;
import com.br.second.tech.challenge.core.usecase.RestauranteUseCase;
import com.br.second.tech.challenge.infra.controller.dto.DiaDTO;
import com.br.second.tech.challenge.infra.controller.dto.RestauranteDTO;
import com.br.second.tech.challenge.infra.controller.dto.SemanaFuncionamentoDTO;
import com.br.second.tech.challenge.infra.controller.mapper.DiaDTOMapper;
import com.br.second.tech.challenge.infra.controller.mapper.RestauranteDTOMapper;
import com.br.second.tech.challenge.infra.controller.mapper.SemanaFuncionamentoDTOMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/restaurante")
public class RestauranteController {

    private DiaDTOMapper diaDTOMapper;
    private RestauranteDTOMapper restauranteDTOMapper;
    private SemanaFuncionamentoDTOMapper semanaFuncionamentoDTOMapper;
    private RestauranteUseCase restauranteUseCase;

    public RestauranteController(DiaDTOMapper diaDTOMapper, RestauranteDTOMapper restauranteDTOMapper, SemanaFuncionamentoDTOMapper semanaFuncionamentoDTOMapper, RestauranteUseCase restauranteUseCase) {
        this.diaDTOMapper = diaDTOMapper;
        this.restauranteDTOMapper = restauranteDTOMapper;
        this.semanaFuncionamentoDTOMapper = semanaFuncionamentoDTOMapper;
        this.restauranteUseCase = restauranteUseCase;
    }

    @GetMapping(value="/{id}", produces = "application/json")
    public RestauranteDTO getRestaurante(@PathVariable long id) {
        Restaurante restaurante = this.restauranteUseCase.buscarRestaurante(id);
        if (restaurante == null) {
            return null;
        }
        return this.restauranteDTOMapper.toDTO(restaurante);
    }

    @PostMapping(produces = "application/json")
    public String postRestaurante(@RequestBody RestauranteDTO restauranteDto) {
        return this.restauranteUseCase.criarRestaurante(this.restauranteDTOMapper.toDomain(restauranteDto));
    }

    @PutMapping(produces = "application/json")
    public String putRestaurante(@RequestBody RestauranteDTO restauranteDto) {
        return this.restauranteUseCase.editarRestaurante(restauranteDTOMapper.toDomain(restauranteDto));
    }

    @DeleteMapping(value="/{id}", produces = "application/json")
    public String deleteRestaurante(@PathVariable long id) {
        return this.restauranteUseCase.deletarRestaurante(id);
    }

    @GetMapping(value="/{idRestaurante}/semana-funcionamento", produces = "application/json")
    public SemanaFuncionamentoDTO getSemanaFuncionamento(@PathVariable long idRestaurante) {
        SemanaFuncionamento semanaFuncionamento = this.restauranteUseCase.buscarSemanaFuncionamento(idRestaurante);
        return semanaFuncionamentoDTOMapper.toDTO(semanaFuncionamento);
    }

    @GetMapping(value="/{idRestaurante}/semana-funcionamento/{dia}", produces = "application/json")
    public DiaDTO getDiaFuncionamento(@PathVariable long idRestaurante, @PathVariable String dia) {
        Dia diaDomain = this.restauranteUseCase.buscarDiaSemanaFuncionamento(idRestaurante, dia);
        return this.diaDTOMapper.toDTO(diaDomain);
    }

    @PutMapping(value="/{idRestaurante}/semana-funcionamento/dia", produces = "application/json")
    public String putDiaSemanaFuncionamento(@PathVariable long idRestaurante, @RequestBody DiaDTO diaDTO) {
        Dia diaDomain = this.diaDTOMapper.toDomain(diaDTO);
        return this.restauranteUseCase.editarDiaFuncionamento(idRestaurante, diaDomain);
    }
}
