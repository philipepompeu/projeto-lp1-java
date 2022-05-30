package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import utfpr.app.Teste;
import utfpr.app.Veiculo;
import utfpr.app.view.ConsultaVeiculoDeCargaFrame;
import utfpr.app.view.ConsultaVeiculoDePasseioFrame;

public class BuscaVeiculoDeCargaPorPlacaAction implements ActionListener {

	private ConsultaVeiculoDeCargaFrame owner;
	
	public BuscaVeiculoDeCargaPorPlacaAction(ConsultaVeiculoDeCargaFrame owner) {
		this.owner = owner;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String placa = owner.pegaPlacaParaBusca();
		ArrayList<Veiculo> lista = Teste.getApp().getRepositorio().getCarrosDeCarga();	
		
		Veiculo buscado = Teste.getApp().executaBuscaPorPlaca(lista, placa);
		
		if (buscado != null) {
			owner.carregaDadosDeVeiculo(buscado);
		}

	}

}
