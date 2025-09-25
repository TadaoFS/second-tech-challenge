package com.br.second.tech.challenge.infra.controller;

import com.br.second.tech.challenge.core.usecase.RestauranteUseCase;
import com.br.second.tech.challenge.infra.controller.dto.DiaDTO;
import com.br.second.tech.challenge.infra.controller.dto.RestauranteDTO;
import com.br.second.tech.challenge.infra.controller.dto.SemanaFuncionamentoDTO;
import com.br.second.tech.challenge.infra.controller.mapper.DiaMapper;
import com.br.second.tech.challenge.infra.controller.mapper.RestauranteMapper;
import com.br.second.tech.challenge.infra.controller.mapper.SemanaFuncionamentoMapper;
import com.br.second.tech.challenge.infra.database.entity.DiaEntity;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import com.br.second.tech.challenge.infra.database.entity.SemanaFuncionamentoEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/restaurante")
public class RestauranteController {

    private DiaMapper diaMapper;
    private RestauranteMapper restauranteMapper;
    private SemanaFuncionamentoMapper semanaFuncionamentoMapper;
    private RestauranteUseCase restauranteUseCase;

    public RestauranteController(DiaMapper diaMapper, RestauranteMapper restauranteMapper, SemanaFuncionamentoMapper semanaFuncionamentoMapper, RestauranteUseCase restauranteUseCase) {
        this.diaMapper = diaMapper;
        this.restauranteMapper = restauranteMapper;
        this.semanaFuncionamentoMapper = semanaFuncionamentoMapper;
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

    @PutMapping(produces = "application/json")
    public String putRestaurante(@RequestBody RestauranteDTO restauranteDto) {
        return this.restauranteUseCase.editarRestaurante(restauranteMapper.toEntity(restauranteDto));
    }

    @DeleteMapping(value="/{id}", produces = "application/json")
    public String deleteRestaurante(@PathVariable long id) {
        return this.restauranteUseCase.deletarRestaurante(id);
    }

    @GetMapping(value="/{idRestaurante}/semana-funcionamento", produces = "application/json")
    public SemanaFuncionamentoDTO getSemanaFuncionamento(@PathVariable long idRestaurante) {
        SemanaFuncionamentoEntity semanaFuncionamento = this.restauranteUseCase.buscarSemanaFuncionamento(idRestaurante);
        return semanaFuncionamentoMapper.toDTO(semanaFuncionamento);
    }

    @GetMapping(value="/{idRestaurante}/semana-funcionamento/{dia}", produces = "application/json")
    public DiaDTO getDiaFuncionamento(@PathVariable long idRestaurante, @PathVariable String dia) {
        DiaEntity diaEntity = this.restauranteUseCase.buscarDiaSemanaFuncionamento(idRestaurante, dia);
        return this.diaMapper.toDTO(diaEntity);
    }

    @PutMapping(value="/{idRestaurante}/semana-funcionamento/dia", produces = "application/json")
    public String putDiaSemanaFuncionamento(@PathVariable long idRestaurante, @RequestBody DiaDTO diaDTO) {
        DiaEntity diaEntity = this.diaMapper.toEntity(diaDTO);
        return this.restauranteUseCase.editarDiaFuncionamento(idRestaurante, diaEntity);
    }
}
