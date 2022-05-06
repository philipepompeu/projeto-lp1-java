package utfpr;

public abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private Motor motor;

    public Veiculo(){
        this.setPlaca(" ");
        this.setMarca(" ");
        this.setModelo(" ");
        this.setCor(" ");
        this.setVelocMax(0);
        this.setQtdRodas(0);
        this.setMotor(new Motor());
    }

    public String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public final void setCor(String cor) {
        this.cor = cor;
    }

    public float getVelocMax() {
        return this.velocMax;
    }

    public final void setVelocMax(float velocMax) {
        this.velocMax = velocMax;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public final void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    private final void setMotor(Motor motor) {
        this.motor = motor;
    }
    public void setMotor(int qtdPist, int potencia){
        if (this.motor == null) {
            this.motor = new Motor();
        }
        this.motor.setQtdPist(qtdPist);
        this.motor.setPotencia(potencia);
    }

    public abstract float calcVel(float velocMax);

    public String toString(){

        StringBuilder builder = new StringBuilder();
        builder.append("Marca:"+ this.getMarca() + "\t");
        builder.append("Modelo:"+ this.getModelo() + System.lineSeparator());
        builder.append("Cor:"+ this.getCor() + "\t");
        builder.append("Qtd. Rodas:"+ this.getQtdRodas() + "\t");
        builder.append("Placa:"+ this.getPlaca() + System.lineSeparator());
        builder.append("Motor: " + System.lineSeparator() + this.motor.toString() + System.lineSeparator());

        String veiculoAsString = builder.toString();
        return veiculoAsString;

    }
}
