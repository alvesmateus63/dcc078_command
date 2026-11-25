package br.com.alvesmateus;

public class BracoRobotico {
    private String posicaoAtual = "REPOUSO";

    public String soldarComponente(String codigoPeca) {
        this.posicaoAtual = "SOLDANDO_" + codigoPeca;
        return "Braço robótico realizou solda na peça: " + codigoPeca + ".";
    }

    public String retornarRepouso() {
        String ultimaPosicao = this.posicaoAtual;
        this.posicaoAtual = "REPOUSO";
        return "Braço robótico retornou ao repouso (estado anterior: " + ultimaPosicao + ").";
    }
}
