package utfpr.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

public class BDVeiculos {
	
	private ArrayList<Veiculo> carrosDeCarga;
    private ArrayList<Veiculo> carrosDePasseio;
    
    public BDVeiculos() {
    	this.carrosDeCarga = new ArrayList<Veiculo>();
        this.carrosDePasseio = new ArrayList<Veiculo>();
	}
    
    private void adicionaVeiculoEmLista(Veiculo carro, ArrayList<Veiculo> lista) {

        lista.add(carro);
    }

	public ArrayList<Veiculo> getCarrosDeCarga() {
		return carrosDeCarga;
	}

	public ArrayList<Veiculo> getCarrosDePasseio() {
		return carrosDePasseio;
	}
	
	public void adicionaVeiculo(Veiculo umVeiculo) {
		
		if (umVeiculo.getClass().equals(Passeio.class)) {
			this.adicionaVeiculoEmLista(umVeiculo, carrosDePasseio);
		}else if(umVeiculo.getClass().equals(Carga.class)) {
			this.adicionaVeiculoEmLista(umVeiculo, carrosDeCarga);
		}
	}
    
    public boolean removeVeiculo(Veiculo umVeiculo) {
    	if (umVeiculo.getClass().equals(Passeio.class)) {
			return this.excluiVeiculoDeLista(umVeiculo, carrosDePasseio);
		}else if(umVeiculo.getClass().equals(Carga.class)) {
			return this.excluiVeiculoDeLista(umVeiculo, carrosDeCarga);
		}
    	return false;
    }
    
    private boolean excluiVeiculoDeLista(Veiculo umVeiculo, ArrayList<Veiculo> lista) {
    	
    	return lista.remove(umVeiculo);
    }
    
    public ArrayList<Veiculo> pegaListaOrdenadaPorPlaca(){
    	
    	this.carrosDeCarga.sort( (Veiculo v1, Veiculo v2) -> 
    			 v1.getPlaca().compareToIgnoreCase(v2.getPlaca()) );
    	
    	this.carrosDeCarga.forEach((Veiculo carro) -> System.out.println(carro));
    	return this.carrosDeCarga;
    }

}
