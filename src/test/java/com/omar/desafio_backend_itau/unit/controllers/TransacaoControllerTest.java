package com.omar.desafio_backend_itau.unit.controllers;

import com.omar.desafio_backend_itau.controllers.TransacaoController;
import com.omar.desafio_backend_itau.dtos.request.TransacaoRequestDTO;
import com.omar.desafio_backend_itau.exceptions.UnprocessableEntityException;
import com.omar.desafio_backend_itau.services.TransacaoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.omar.desafio_backend_itau.utils.EntityUtils.criarTransacaoRequestDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.BDDMockito.*;

@ExtendWith(SpringExtension.class)
class TransacaoControllerTest {

    @InjectMocks
    private TransacaoController transacaoController;

    @Mock
    private TransacaoService transacaoService;

    @Test
    @DisplayName("salvarTransacao deve adicionar uma TransacaoRequestDTO a ArrayList e retornar http status 201 quando bem sucedido")
    void salvarTransacao_AdicionaTransacaoRequestDTOAArrayListERetornaStatus201_QuandoBemSucedido() {
        doNothing().when(transacaoService).salvarTransacao(ArgumentMatchers.any(TransacaoRequestDTO.class));
        ResponseEntity<Void> responseEntity = transacaoController.salvarTransacao(criarTransacaoRequestDTO());
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        ArgumentCaptor<TransacaoRequestDTO> captor = ArgumentCaptor.forClass(TransacaoRequestDTO.class);

        verify(transacaoService, times(1)).salvarTransacao(captor.capture());
    }

    @Test
    @DisplayName("salvarTransacao não deve adicionar uma TransacaoRequestDTO a ArrayList e deve retornar uma UnprocessableEntityException quando algum erro de validação ocorrer")
    void salvarTransacao_NaoAdicionaTransacaoRequestDTOAArrayListERetornaUnprocessableEntityException_QuandoAlgumErroDeValidacaoOcorre(){
        doThrow(new UnprocessableEntityException())
                .when(transacaoService).salvarTransacao(ArgumentMatchers.any(TransacaoRequestDTO.class));
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(() -> transacaoController.salvarTransacao(criarTransacaoRequestDTO()))
                .withMessage("Erro durante o processamento da entidade");
    }

    @Test
    @DisplayName("removerTransacoes deve remover todas as TransacaoRequestDTO do ArrayList e retornar um http status 200 quando bem sucedido")
    void removerTransacoes_DeveRemoverTodasAsTransacaoRequestDTODoArrayListERetornarStatus200_QuandoBemSucedido() {
        ResponseEntity<Void> responseEntity = transacaoController.removerTransacoes();
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        verify(transacaoService, times(1)).removerTransacoes();
    }
}