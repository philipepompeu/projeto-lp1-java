package utfpr;

import java.util.Scanner;

public class Leitura {
    private Scanner scanner;    

    public Leitura(){
        this.scanner = new Scanner(System.in);        
    }

    public String entDados(String c) {
        return "0";
    }    

    public int readInt(String mensagem){
        this.mostrarMensagem(mensagem);
        int resultado = this.scanner.nextInt();
        this.scanner.nextLine();//limpa \n
        return resultado;
    }

    public float readFloat(String mensagem){
        this.mostrarMensagem(mensagem);
        return this.scanner.nextFloat();
    }

    public String readString(String mensagem){

        this.mostrarMensagem(mensagem);

        return this.scanner.nextLine();
    }

    public void mostrarMensagem(String mensagem){
        System.out.println(mensagem);
    }        

    public Veiculo buildVeiculo(boolean isCarga) {
        System.out.println("Informe abaixo os dados do próximo veículo: ");
        String marca = this.readString("Qual a marca?");
        String modelo = this.readString("Qual o modelo?");
        String   cor = this.readString("Qual a cor?");
        String placa = this.readString("Qual a placa?");

        int qtdRodas = this.readInt("Qual a quantidade de rodas?");
        int potencia = this.readInt("Qual a potência(cv) do motor?");
        int km = this.readInt("Qual a quilometragem?");

        Veiculo result = isCarga ? new Carga() : new Passeio();
        result.setMarca(marca);
        result.setModelo(modelo);
        result.setCor(cor);
        result.setQtdRodas(qtdRodas);
        result.setPlaca(placa);
        result.setMotor(km,potencia);

        if (isCarga) {
            int tara = this.readInt("Qual a tara(peso) do veículo em kg?");
            ((Carga) result).setTara(tara);
            int cargaMax = this.readInt("Qual a carga máxima do veículo em kg?");
            ((Carga)result).setCargaMax(cargaMax);
        }else{
            int qtdPassageiros = this.readInt("Qual a quantidade de passageiros?");
            ((Passeio)result).setQtdPassageiros(qtdPassageiros);
        }

        float velocMaxPadrao = (isCarga ? 90 : 100);
        
        
        float velocMax = this.readFloat("Qual a velocidade maxima do veículo?");
        
        this.atribuiVelocMax(result,velocMax,velocMaxPadrao);

        return result;
    }
    
    private void atribuiVelocMax(Veiculo umVeiculo, float velocidade, float padrao) {
    	 try {
    		 umVeiculo.setVelocMax(velocidade);
 		} catch (VelocException e) {
 			this.mostrarMensagem(e.getMessage()); 			
 			if (padrao > 0) {
				this.atribuiVelocMax(umVeiculo, padrao, 0);
			}

 		}
    }
}