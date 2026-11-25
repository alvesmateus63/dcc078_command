package br.com.alvesmateus;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PainelControleFabrica {
    private final List<ComandoMaquina> filaProducao = new ArrayList<>();
    private final Stack<ComandoMaquina> historicoExecutados = new Stack<>();

    public void adicionarComando(ComandoMaquina comando) {
        filaProducao.add(comando);
    }

    public List<String> processarLote() {
        List<String> relatorioExecucao = new ArrayList<>();

        for (ComandoMaquina comando : filaProducao) {
            String resultado = comando.executar();
            relatorioExecucao.add(resultado);
            historicoExecutados.push(comando);
        }

        filaProducao.clear();
        return relatorioExecucao;
    }

    public String desfazerUltimoComando() {
        if (historicoExecutados.isEmpty()) {
            return "Nenhum comando disponível para desfazer.";
        }
        ComandoMaquina ultimoComando = historicoExecutados.pop();
        return ultimoComando.desfazer();
    }
}
