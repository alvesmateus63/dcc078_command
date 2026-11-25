package br.com.alvesmateus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComandoMaquinaTest {
    @Test
    void deveExecutarEDesfazerComandoLigarEsteira() {
        EsteiraTransportadora esteira = new EsteiraTransportadora();
        ComandoMaquina comando = new ComandoLigarEsteira(esteira, 150);

        String retornoExecucao = comando.executar();
        assertEquals("Esteira ligada a 150 RPM.", retornoExecucao);
        assertTrue(esteira.isEmMovimento());

        String retornoDesfazer = comando.desfazer();
        assertEquals("Esteira desligada.", retornoDesfazer);
        assertFalse(esteira.isEmMovimento());
    }

    @Test
    void deveExecutarEDesfazerComandoSoldarPeca() {
        BracoRobotico braco = new BracoRobotico();
        ComandoMaquina comando = new ComandoSoldarPeca(braco, "CHASSI-09");

        String retornoExecucao = comando.executar();
        assertEquals("Braço robótico realizou solda na peça: CHASSI-09.", retornoExecucao);

        String retornoDesfazer = comando.desfazer();
        assertEquals("Braço robótico retornou ao repouso (estado anterior: SOLDANDO_CHASSI-09).", retornoDesfazer);
    }
}
