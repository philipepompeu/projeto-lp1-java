package utfpr.app;

public final class Passeio extends Veiculo implements Calcular{
    private int qtdPassageiros;

    public Passeio(){
        super();
        this.setQtdPassageiros(0);
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public float calcVel(float velocMax) {

        return (float)(velocMax*1000);
    }

    @Override
    public String toString(){

        String passeioAsString = super.toString();

        StringBuilder builder = new StringBuilder(passeioAsString);
        builder.append("Tipo: Passeio"+"\t");
        builder.append("Velocidade Máxima:" + this.calcVel(this.getVelocMax()) + " m/h"+System.lineSeparator());
        builder.append("Resultado método calcular: " + this.calcular());
        passeioAsString = builder.toString();

        return passeioAsString;
    }

    public int calcular(){

        int resultado = 0;

        StringBuilder builder = new StringBuilder();

        builder.append(this.getPlaca());
        builder.append(this.getMarca());
        builder.append(this.getModelo());
        builder.append(this.getCor());

        resultado = builder.toString().length();

        return resultado;
    }
}
