package utfpr;

import java.util.ArrayList;

public class BDVeiculos {
	
	private ArrayList<Veiculo> carrosDeCarga;
    private ArrayList<Veiculo> carrosDePasseio;
    
    public BDVeiculos() {
    	this.carrosDeCarga = new ArrayList<Veiculo>();
        this.carrosDePasseio = new ArrayList<Veiculo>();
	}
    
    private void adicionaVeiculoEmLista(Veiculo carro, ArrayList<Veiculo> lista) throws Exception {

        if (lista.size()+1 > 5) throw new Exception("Quantidade máxima de veículos atingida.");

        lista.add(carro);
    }

	@SuppressWarnings("unchecked")
	public ArrayList<Veiculo> getCarrosDeCarga() {
		return (ArrayList<Veiculo>)carrosDeCarga.clone();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Veiculo> getCarrosDePasseio() {
		return (ArrayList<Veiculo>)carrosDePasseio.clone();
	}
	
	public void adicionaVeiculo(Veiculo umVeiculo) throws Exception {
		
		if (umVeiculo.getClass().equals(Passeio.class)) {
			this.adicionaVeiculoEmLista(umVeiculo, carrosDePasseio);
		}else if(umVeiculo.getClass().equals(Carga.class)) {
			this.adicionaVeiculoEmLista(umVeiculo, carrosDeCarga);
		}
	}
    
    

}
