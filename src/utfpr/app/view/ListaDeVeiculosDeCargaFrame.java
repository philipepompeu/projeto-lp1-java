package utfpr.app.view;

import java.util.ArrayList;

import utfpr.app.Teste;
import utfpr.app.Veiculo;

public class ListaDeVeiculosDeCargaFrame extends ListaDeVeiculosFrame {

	public ListaDeVeiculosDeCargaFrame() {
		super();
		this.setTitle("Lista de Veículos de Carga");
	}
	@Override
	protected ArrayList<Veiculo> getListaDeVeiculos() {
		// TODO Auto-generated method stub
		return Teste.getApp().getRepositorio().getCarrosDeCarga();
	}

	@Override
	public void limpaListaDeVeiculos() {
		Teste.getApp().getRepositorio().getCarrosDeCarga().clear();

	}

}
