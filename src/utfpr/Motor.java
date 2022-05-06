package utfpr;

public class Motor {

    private int qtdPist;
    private int potencia;

    public Motor(){
        this.qtdPist = 0;
        this.potencia = 0;
    }

    public int getQtdPist() {
        return qtdPist;
    }

    public void setQtdPist(int qtdPist) {
        this.qtdPist = qtdPist;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String toString(){
        String motorAsString = "";

        motorAsString += "\tPotência: "+ Integer.toString(this.potencia) + "cv";
        motorAsString += System.lineSeparator();
        motorAsString += "\tQuilometragem: "+ Integer.toString(this.qtdPist)+"km";

        return motorAsString;

    }
}
