package br.com.alvesmateus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PainelControleFabricaTest {
    private PainelControleFabrica painel;
    private EsteiraTransportadora esteira;
    private BracoRobotico braco;

    @BeforeEach
    void setUp() {
        painel = new PainelControleFabrica();
        esteira = new EsteiraTransportadora();
        braco = new BracoRobotico();
    }

    @Test
    void deveProcessarLoteNaOrdemERetornarRelatorioCompleto() {
        painel.adicionarComando(new ComandoLigarEsteira(esteira, 100));
        painel.adicionarComando(new ComandoSoldarPeca(braco, "MOTOR-X1"));

        List<String> relatorio = painel.processarLote();

        assertEquals(2, relatorio.size());
        assertEquals("Esteira ligada a 100 RPM.", relatorio.get(0));
        assertEquals("Braço robótico realizou solda na peça: MOTOR-X1.", relatorio.get(1));
        assertTrue(esteira.isEmMovimento());
    }

    @Test
    void deveLimparFilaAposProcessarLote() {
        painel.adicionarComando(new ComandoLigarEsteira(esteira, 100));
        painel.processarLote();

        List<String> segundoRelatorio = painel.processarLote();
        assertTrue(segundoRelatorio.isEmpty());
    }

    @Test
    void deveDesfazerComandosNaOrdemInversaDeExecucao() {
        painel.adicionarComando(new ComandoLigarEsteira(esteira, 100));
        painel.adicionarComando(new ComandoSoldarPeca(braco, "MOTOR-X1"));
        painel.processarLote();

        String primeiroUndo = painel.desfazerUltimoComando();
        assertEquals("Braço robótico retornou ao repouso (estado anterior: SOLDANDO_MOTOR-X1).", primeiroUndo);
        assertTrue(esteira.isEmMovimento());

        String segundoUndo = painel.desfazerUltimoComando();
        assertEquals("Esteira desligada.", segundoUndo);
        assertFalse(esteira.isEmMovimento());
    }

    @Test
    void deveRetornarMensagemAvisoQuandoNaoHouverComandosParaDesfazer() {
        String resultado = painel.desfazerUltimoComando();
        assertEquals("Nenhum comando disponível para desfazer.", resultado);
    }
}
