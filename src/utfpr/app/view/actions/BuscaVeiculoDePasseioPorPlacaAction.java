package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import utfpr.app.Teste;
import utfpr.app.Veiculo;
import utfpr.app.view.ConsultaVeiculoDePasseioFrame;

public class BuscaVeiculoDePasseioPorPlacaAction implements ActionListener {
	private ConsultaVeiculoDePasseioFrame owner;
	
	public BuscaVeiculoDePasseioPorPlacaAction(ConsultaVeiculoDePasseioFrame owner) {
		this.owner = owner;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String placa = owner.pegaPlacaParaBusca();
		ArrayList<Veiculo> lista = Teste.getApp().getRepositorio().getCarrosDePasseio();
		Veiculo buscado = Teste.getApp().executaBuscaPorPlaca(lista, placa);
		
		if (buscado != null) {
			owner.carregaDadosDeVeiculo(buscado);
		}

	}

}
