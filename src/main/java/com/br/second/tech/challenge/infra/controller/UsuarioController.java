package com.br.second.tech.challenge.infra.controller;

import com.br.second.tech.challenge.core.usecase.UsuarioUseCase;
import com.br.second.tech.challenge.infra.controller.dto.UsuarioDTO;
import com.br.second.tech.challenge.infra.controller.mapper.UsuarioMapper;
import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @PostMapping
    public UsuarioDTO criar(@RequestBody UsuarioDTO dto) {
        UsuarioEntity entity = UsuarioMapper.toEntity(dto);
        UsuarioEntity salvo = usuarioUseCase.salvar(entity);
        return UsuarioMapper.toDTO(salvo);
    }

    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return usuarioUseCase.listarTodos()
                .stream()
                .map(UsuarioMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return UsuarioMapper.toDTO(usuarioUseCase.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioUseCase.deletar(id);
    }
}
