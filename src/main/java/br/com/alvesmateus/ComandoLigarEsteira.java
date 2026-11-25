package br.com.alvesmateus;

public class ComandoLigarEsteira implements ComandoMaquina {
    private final EsteiraTransportadora esteira;
    private final int velocidadeAlvo;

    public ComandoLigarEsteira(EsteiraTransportadora esteira, int velocidadeAlvo) {
        this.esteira = esteira;
        this.velocidadeAlvo = velocidadeAlvo;
    }

    @Override
    public String executar() {
        return esteira.ligar(velocidadeAlvo);
    }

    @Override
    public String desfazer() {
        return esteira.desligar();
    }
}
