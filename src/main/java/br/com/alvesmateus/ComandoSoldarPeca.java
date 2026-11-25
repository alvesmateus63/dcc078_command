package br.com.alvesmateus;

public class ComandoSoldarPeca implements ComandoMaquina {
    private final BracoRobotico braco;
    private final String codigoPeca;

    public ComandoSoldarPeca(BracoRobotico braco, String codigoPeca) {
        this.braco = braco;
        this.codigoPeca = codigoPeca;
    }

    @Override
    public String executar() {
        return braco.soldarComponente(codigoPeca);
    }

    @Override
    public String desfazer() {
        return braco.retornarRepouso();
    }
}
