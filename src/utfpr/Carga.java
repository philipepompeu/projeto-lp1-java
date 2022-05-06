package utfpr;

public final class Carga extends Veiculo implements Calcular{

    private int tara;
    private int cargaMax;
    public Carga(){
        super();
        this.setCargaMax(0);
        this.setTara(0);
    }

    @Override
    public float calcVel(float velocMax) {
        float resultado = (float) (velocMax*10.000);

        return resultado;
    }

    public int getTara() {
        return tara;
    }
    public void setTara(int tara) {
        this.tara = tara;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }
    public int getCargaMax() {
        return cargaMax;
    }

    @Override
    public String toString(){

        String cargaAsString = super.toString();
        StringBuilder builder = new StringBuilder(cargaAsString);
        builder.append("Tipo: Carga"+"\t");
        builder.append("Velocidade Máxima:" + this.calcVel(this.getVelocMax()) + " cm/h"+System.lineSeparator());
        builder.append("Resultado método calcular: " + this.calcular());

        cargaAsString = builder.toString();

        return cargaAsString;
    }

    public int calcular(){
        int resultado = 0;

        resultado += ((int) this.getVelocMax());
        resultado += this.getQtdRodas();
        resultado += this.getTara();
        resultado += this.getCargaMax();

        return resultado;
    }
}
