package com.br.second.tech.challenge.core.usecase;

import com.br.second.tech.challenge.infra.database.entity.UsuarioEntity;
import com.br.second.tech.challenge.infra.database.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public UsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioEntity salvar(UsuarioEntity usuario) {
        if (usuario.getId() == null) {
            usuario.setDataCriacao(LocalDateTime.now());
            usuario.setStatus("ATIVO");
        }
        usuario.setDataAtualizacao(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioEntity> listarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado para exclusão");
        }
        usuarioRepository.deleteById(id);
    }
}
