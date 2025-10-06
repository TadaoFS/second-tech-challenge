package com.br.second.tech.challenge.core.usecase;

import com.br.second.tech.challenge.core.domain.Dia;
import com.br.second.tech.challenge.core.domain.Restaurante;
import com.br.second.tech.challenge.core.domain.SemanaFuncionamento;
import com.br.second.tech.challenge.core.enums.Dias;
import com.br.second.tech.challenge.core.gateway.DiaGateway;
import com.br.second.tech.challenge.core.gateway.RestauranteGateway;
import com.br.second.tech.challenge.infra.database.entity.DiaEntity;
import com.br.second.tech.challenge.infra.database.entity.RestauranteEntity;
import com.br.second.tech.challenge.infra.database.entity.SemanaFuncionamentoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestauranteUseCaseTest {

    Dia dia;

    DiaEntity diaEntity;

    Restaurante restaurante;

    RestauranteEntity restauranteEntity;

    SemanaFuncionamento semanaFuncionamento;

    SemanaFuncionamentoEntity semanaFuncionamentoEntity;

    @Mock
    DiaGateway diaGateway;

    @Mock
    RestauranteGateway restauranteGateway;

    @InjectMocks
    RestauranteUseCase restauranteUseCase;

    @BeforeEach
    void givenRestauranteEntity(){
        restauranteEntity = new RestauranteEntity();
        restauranteEntity.setId(1L);
    }

    @BeforeEach
    void givenRestaurante(){
        restaurante = new Restaurante();
        restaurante.setId(1L);
    }

    void givenSemanaFuncionamento(){
        semanaFuncionamento = new SemanaFuncionamento();
        semanaFuncionamento.setId(1L);
    }

    void givenSemanaFuncionamentoEntity(){
        semanaFuncionamentoEntity = new SemanaFuncionamentoEntity();
        semanaFuncionamentoEntity.setId(1L);
    }

    void givenDia(){
        dia = new Dia();
        dia.setId(1L);
        dia.setNome(Dias.SABADO);
        dia.setHorarioAbertura("08:00"); // Set valid horarioAbertura
    }

    void givenDiaEntity(){
        diaEntity = new DiaEntity();
        diaEntity.setId(1L);
        diaEntity.setNome(Dias.SABADO);
        diaEntity.setHorarioAbertura("08:00"); // Set valid horarioAbertura
    }

    @Test
    @DisplayName("retorna restaurante esperado")
    void buscarRestauranteExistente() {
        //given
        givenRestaurante();
        var id = restauranteEntity.getId();

        //when
        when(restauranteGateway.findById(id)).thenReturn(Optional.of(restauranteEntity));
        var restaurante = restauranteUseCase.buscarRestaurante(id);

        //then
        assertNotNull(restaurante);
        assertEquals(restauranteEntity.getId(), restaurante.getId());
    }

    @Test
    @DisplayName("não encontra restaurante")
    void buscarRestauranteNãoExistente() {
        //given
        givenRestaurante();
        var id = restauranteEntity.getId();

        //when
        when(restauranteGateway.findById(id)).thenReturn(Optional.empty());
        var restaurante = restauranteUseCase.buscarRestaurante(id);

        //then
        assertNull(restaurante);
    }

    @Test
    @DisplayName("retorna erro ao buscar restaurante")
    void erroBuscarRestaurante() {
        //given

        //when
        when(restauranteGateway.findById(restauranteEntity.getId()))
                .thenThrow(new RuntimeException("Connection Error"));
        var exception = assertThrows(RuntimeException.class, () ->
                restauranteUseCase.buscarRestaurante(restauranteEntity.getId()));

        //then
        assertEquals("Erro ao buscar restaurante: Connection Error", exception.getMessage());
    }

    @Test
    @DisplayName("cria restaurante com sucesso")
    void criarRestaurante() {
        //given
        restauranteEntity.setNome("Restaurante Teste");

        //when
        when(restauranteGateway.save(any(RestauranteEntity.class))).thenReturn(restauranteEntity);
        var result = restauranteUseCase.criarRestaurante(restaurante);

        //then
        assertEquals("Restaurante Restaurante Teste criado com sucesso!", result);
    }

    @Test
    @DisplayName("retorna erro ao criar restaurante")
    void erroCriarRestaurante() {
        //given
        restauranteEntity.setNome("Restaurante Teste");

        //when
        when(restauranteGateway.save(any(RestauranteEntity.class))).thenThrow(new RuntimeException("Connection Error"));
        var exception = assertThrows(RuntimeException.class, () -> restauranteUseCase.criarRestaurante(restaurante));

        //then
        assertEquals("Erro ao criar restaurante: Connection Error", exception.getMessage());
    }

    @Test
    @DisplayName("edita restaurante com sucesso")
    void editarRestaurante() {
        //given
        restauranteEntity.setNome("Restaurante Teste");

        //when
        when(restauranteGateway.findById(restauranteEntity.getId())).thenReturn(Optional.of(restauranteEntity));
        when(restauranteGateway.save(any(RestauranteEntity.class))).thenReturn(restauranteEntity);
        var result = restauranteUseCase.editarRestaurante(restaurante);

        //then
        assertEquals("Restaurante Restaurante Teste atualizado com sucesso!", result);
    }

    @Test
    @DisplayName("mantem datas do restaurante ao editar")
    void naoEditaDatasRestaurante() {
        //given
        LocalDateTime dataCriacaoOriginal = LocalDateTime.parse("2023-09-09T09:09:09");
        LocalDateTime dataAtualizacaoAntiga = LocalDateTime.parse("2023-10-10T10:10:10");

        var restauranteExistente = new RestauranteEntity();
        restauranteExistente.setId(1L);
        restauranteExistente.setNome("Restaurante Original");
        restauranteExistente.setDataCriacao(dataCriacaoOriginal);
        restauranteExistente.setDataAtualizacao(dataAtualizacaoAntiga);

        var restauranteAtualizado = new Restaurante();
        restauranteAtualizado.setId(1L);
        restauranteAtualizado.setNome("Restaurante Atualizado");

        //when
        when(restauranteGateway.findById(1L)).thenReturn(Optional.of(restauranteExistente));
        when(restauranteGateway.save(any(RestauranteEntity.class))).thenAnswer(i -> i.getArguments()[0]);
        var result = restauranteUseCase.editarRestaurante(restauranteAtualizado);

        //then
        assertEquals("Restaurante Restaurante Atualizado atualizado com sucesso!", result);
        assertEquals(dataCriacaoOriginal, restauranteAtualizado.getDataCriacao());
        assertNotEquals(dataAtualizacaoAntiga, restauranteAtualizado.getDataAtualizacao());
        assertTrue(restauranteAtualizado.getDataAtualizacao().isAfter(dataAtualizacaoAntiga));
    }

    @Test
    @DisplayName("não encontra restaurante para editar")
    void naoEditaRestaurante() {
        //given

        //when
        when(restauranteGateway.findById(restauranteEntity.getId())).thenReturn(Optional.empty());
        var result = restauranteUseCase.editarRestaurante(restaurante);

        //then
        assertEquals("Restaurante não encontrado para atualização.", result);
    }

    @Test
    @DisplayName("erro ao editar restaurante")
    void erroEditaRestaurante() {
        //given

        //when
        when(restauranteGateway.findById(restauranteEntity.getId())).thenReturn(Optional.of(restauranteEntity));
        when(restauranteGateway.save(any(RestauranteEntity.class))).thenThrow(new RuntimeException("Connection Error"));
        var exception = assertThrows(RuntimeException.class, () -> restauranteUseCase.editarRestaurante(restaurante));

        //then
        assertEquals("Erro ao atualizar restaurante: Connection Error", exception.getMessage());
    }

    @Test
    @DisplayName("deleta restaurante com sucesso")
    void deletarRestaurante() {
        //given

        //when
        when(restauranteGateway.existsById(restauranteEntity.getId())).thenReturn(true);
        var result = restauranteUseCase.deletarRestaurante(restauranteEntity.getId());

        //then
        assertEquals("Restaurante deletado com sucesso!", result);
    }

    @Test
    @DisplayName("não encontra restaurante para deletar")
    void naoDeletarRestaurante() {
        //given

        //when
        when(restauranteGateway.existsById(restauranteEntity.getId())).thenReturn(false);
        var result = restauranteUseCase.deletarRestaurante(restauranteEntity.getId());

        //then
        assertEquals("Restaurante não encontrado para deleção.", result);
    }

    @Test
    @DisplayName("erro ao deleta restaurante")
    void erroDeletarRestaurante() {
        //given

        //when
        when(restauranteGateway.existsById(restauranteEntity.getId()))
                .thenThrow(new RuntimeException("Connection Error"));
        var exception = assertThrows(RuntimeException.class, () ->
                restauranteUseCase.deletarRestaurante(restauranteEntity.getId()));

        //then
        assertEquals("Erro ao deletar restaurante: Connection Error", exception.getMessage());
    }

    @Test
    @DisplayName("retorna semana de funcionamento do restaurante")
    void buscarSemanaRestauranteExistente() {
        //given
        givenSemanaFuncionamentoEntity();
        restauranteEntity.setSemanaFuncionamento(semanaFuncionamentoEntity);
        var id = restauranteEntity.getId();

        //when
        when(restauranteGateway.findById(id)).thenReturn(Optional.of(restauranteEntity));
        var semanaFuncionamento = restauranteUseCase.buscarSemanaFuncionamento(id);

        //then
        assertNotNull(semanaFuncionamento);
        assertEquals(semanaFuncionamentoEntity.getId(), semanaFuncionamento.getId());
    }
    @Test
    @DisplayName("não encontra restaurante para buscar semana de funcionamento")
    void buscarSemanaRestauranteNaoExiste() {
        //given
        var id = restauranteEntity.getId();

        //when
        when(restauranteGateway.findById(id)).thenReturn(Optional.empty());
        var exception = assertThrows(RuntimeException.class, () ->
                restauranteUseCase.buscarSemanaFuncionamento(restauranteEntity.getId()));

        //then
        assertEquals("Erro ao buscar os dias de funcionamento: Restaurante não encontrado.", exception.getMessage());
    }

//    @Test
//    @DisplayName("retorna dia da semana de funcionamento do restaurante")
//    void buscarDiaSemanaRestauranteExistente() {
//        //given
//        givenSemanaFuncionamentoEntity();
//        givenSemanaFuncionamento();
//        givenDia();
//        givenDiaEntity();
//        semanaFuncionamentoEntity.setSabado(diaEntity);
//        restaurante.setSemanaFuncionamento(semanaFuncionamento);
//        restauranteEntity.setSemanaFuncionamento(semanaFuncionamentoEntity);
//        var id = restauranteEntity.getId();
//
//        //when
//        when(restauranteGateway.findById(id)).thenReturn(Optional.of(restauranteEntity));
//        when(restauranteUseCase.buscarRestaurante(id)).thenReturn(restaurante);
//        var diaFuncionamento = restauranteUseCase.buscarDiaSemanaFuncionamento(id, "SABADO");
//
//        //then
//        assertNotNull(diaFuncionamento);
//        assertEquals(diaEntity.getId(), diaFuncionamento.getId());
//    }

    @Test
    @DisplayName("não encontra restaurante para buscar dia da semana de funcionamento")
    void buscarDiaSemanaRestauranteNaoExiste() {
        //given
        var id = restauranteEntity.getId();

        //when
        when(restauranteGateway.findById(id)).thenReturn(Optional.empty());
        var exception = assertThrows(RuntimeException.class, () ->
                restauranteUseCase.buscarDiaSemanaFuncionamento(restauranteEntity.getId(), "SABADO"));

        //then
        assertEquals("Erro ao buscar dia de funcionamento: Restaurante não encontrado.", exception.getMessage());
    }

    @Test
    @DisplayName("edita dia da semana de funcionamento")
    void editaDiaSemanaRestauranteNaoExiste() {
        //given
        givenSemanaFuncionamentoEntity();
        givenDia();
        givenDiaEntity();
        semanaFuncionamentoEntity.setSabado(diaEntity);
        restauranteEntity.setSemanaFuncionamento(semanaFuncionamentoEntity);
        var id = restauranteEntity.getId();

        //when
        when(restauranteGateway.findById(id)).thenReturn(Optional.of(restauranteEntity));
        when(diaGateway.save(any(DiaEntity.class))).thenReturn(diaEntity);
        var result = restauranteUseCase.editarDiaFuncionamento(id, dia);

        //then
        assertEquals("Dia atualizado com sucesso!", result);
    }

    @Test
    @DisplayName("não edita dia da semana de funcionamento para restaurante nulo")
    void naoEditaDiaSemanaRestauranteNaoExiste() {
        //given
        var id = restauranteEntity.getId();

        //when
        when(restauranteGateway.findById(id)).thenReturn(Optional.empty());
        var result = restauranteUseCase.editarDiaFuncionamento(id, dia);

        //then
        assertEquals("Não foi possível atualizar o dia.", result);
    }

    @Test
    @DisplayName("erro ao editar dia da semana de funcionamento")
    void erroEditaDiaSemanaRestauranteNaoExiste() {
        //given
        var id = restauranteEntity.getId();

        //when
        when(restauranteGateway.findById(id)).thenThrow(new RuntimeException("Connection Error"));
        var exception = assertThrows(RuntimeException.class, () ->
                restauranteUseCase.editarDiaFuncionamento(id, dia));

        //then
        assertEquals("Erro ao atualizar dia de funcionamento: Connection Error", exception.getMessage());
    }
}