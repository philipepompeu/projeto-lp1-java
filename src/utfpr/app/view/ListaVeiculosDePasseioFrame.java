package utfpr.app.view;

import java.util.ArrayList;

import utfpr.app.Teste;
import utfpr.app.Veiculo;

public class ListaVeiculosDePasseioFrame extends ListaDeVeiculosFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ListaVeiculosDePasseioFrame() {
		super();
		this.setTitle("Lista de Veículos de Passeio");
	}	
	

	@Override
	protected ArrayList<Veiculo> getListaDeVeiculos() {
		return Teste.getApp().getRepositorio().getCarrosDePasseio();
	}

	@Override
	public void limpaListaDeVeiculos() {
		Teste.getApp().getRepositorio().getCarrosDePasseio().clear();		
	}
}
