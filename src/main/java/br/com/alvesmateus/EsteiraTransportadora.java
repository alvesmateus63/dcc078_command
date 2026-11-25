package br.com.alvesmateus;

public class EsteiraTransportadora {
    private boolean emMovimento = false;
    private int velocidadeRpm = 0;

    public String ligar(int velocidade) {
        this.emMovimento = true;
        this.velocidadeRpm = velocidade;
        return "Esteira ligada a " + this.velocidadeRpm + " RPM.";
    }

    public String desligar() {
        this.emMovimento = false;
        this.velocidadeRpm = 0;
        return "Esteira desligada.";
    }

    public boolean isEmMovimento() {
        return emMovimento;
    }
}
