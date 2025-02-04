package com.omar.desafio_backend_itau.unit.services;

import com.omar.desafio_backend_itau.dtos.request.TransacaoRequestDTO;
import com.omar.desafio_backend_itau.exceptions.UnprocessableEntityException;
import com.omar.desafio_backend_itau.services.TransacaoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.OffsetDateTime;
import java.util.List;

import static com.omar.desafio_backend_itau.utils.EntityUtils.criarTransacaoRequestDTO;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService transacaoService;

    @Test
    @DisplayName("salvarTransacao deve adicionar uma TransacaoRequestDTO ao ArrayList e não lançar exceptions quando bem sucedido")
    void salvarTransacao_DeveAdicionarUmaTransacaoRequestDTOAoArrayListENaoLancarExceptions_QuandoBemSucedido() {
        assertThatCode(() -> transacaoService.salvarTransacao(criarTransacaoRequestDTO()))
                .doesNotThrowAnyException();
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoesPorTempo(10000);
        assertThat(transacoes).isNotNull().isNotEmpty().hasSize(1);
    }

    @Test
    @DisplayName("salvarTransacao deve lançar uma UnprocessableEntityException quando dataHora for null")
    void salvarTransacao_LancaUnprocessableEntityException_QuandoDataHoraForNull(){
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(() -> transacaoService.salvarTransacao(new TransacaoRequestDTO(678.99D, null)))
                .withMessage("atributos dataHora e valor não podem ser nulos");
    }

    @Test
    @DisplayName("salvarTransacao deve lançar uma UnprocessableEntityException quando valor for null")
    void salvarTransacao_LancaUnprocessableEntityException_QuandoValorForNull(){
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(() -> transacaoService.salvarTransacao(new TransacaoRequestDTO(null, OffsetDateTime.now())))
                .withMessage("atributos dataHora e valor não podem ser nulos");
    }

    @Test
    @DisplayName("salvarTransacao deve lançar uma UnprocessableEntityException quando dataHora for posterior a data e hora atuais")
    void salvarTransacao_LancaUnprocessableEntityException_QuandoDataHoraForPosteriorADataEHoraAtuais(){
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(() -> transacaoService.salvarTransacao(new TransacaoRequestDTO(678.99D, OffsetDateTime.now().plusHours(10))))
                .withMessage("data e hora do atributo dataHora devem ser anteriores a data e hora atuais");
    }

    @Test
    @DisplayName("salvarTransacao deve lançar uma UnprocessableEntityException quando atributo valor for menor que 0")
    void salvarTransacao_LancaUnprocessableEntityException_QuandoAtributoValorForMenorQueZero(){
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(() -> transacaoService.salvarTransacao(new TransacaoRequestDTO(-5D, OffsetDateTime.now())))
                .withMessage("valor deve ser maior ou igual a 0");
    }

    @Test
    @DisplayName("removerTransacoes deve remover todas as TransacaoRequestDTO do ArrayList e não lançar exception quando bem sucedido")
    void removerTransacoes_RemoveTodasAsTransacaoRequestDTODoArrayListENaoLancaException_QuandoBemSucedido() {
        assertThatCode(() -> transacaoService.removerTransacoes())
                .doesNotThrowAnyException();
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoesPorTempo(10000);
        assertThat(transacoes).isNotNull().isEmpty();
    }

    @Test
    @DisplayName("buscarTransacoesPorTempo deve retornar uma lista de TransacaoRequestDTO quando a busca das últimas transações de acordo com a quantidade de segundos passados for bem sucedida")
    void buscarTransacoesPorTempo_RetornaListaDeTransacaoRequestDTO_QuandoABuscaDasUltimasTransacoesNosUltimosSegundosPassadosComoParametroEBemSucedida() {
        transacaoService.salvarTransacao(criarTransacaoRequestDTO());
        transacaoService.salvarTransacao(criarTransacaoRequestDTO());
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoesPorTempo(60);
        assertThat(transacoes).isNotNull().isNotEmpty().hasSize(2);
    }

    @Test
    @DisplayName("buscarTransacoesPorTempo deve retornar uma lista vazia quando a busca das últimas transações de acordo com a quantidade de segundos passados não obter resultados")
    void buscarTransacoesPorTempo_RetornaListaVazia_QuandoNaoHouveremTransacoesNoTempoEmSegundosPassado(){
        transacaoService.salvarTransacao(criarTransacaoRequestDTO());
        transacaoService.salvarTransacao(criarTransacaoRequestDTO());
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoesPorTempo(10);
        assertThat(transacoes).isNotNull().isEmpty();
    }
}