package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import utfpr.app.view.ConsultaVeiculoDeCargaFrame;
import utfpr.app.view.ConsultaVeiculoDePasseioFrame;
import utfpr.app.view.VeiculoFrame;
import utfpr.app.*;

public class ExcluiVeiculoAction implements ActionListener {
	private ConsultaVeiculoDeCargaFrame consultaCarga;
	private ConsultaVeiculoDePasseioFrame consultaPasseio;
	
	public ExcluiVeiculoAction(ConsultaVeiculoDeCargaFrame consultaCarga) {
		this.consultaCarga = consultaCarga;
	}
	public ExcluiVeiculoAction(ConsultaVeiculoDePasseioFrame consultaPasseio) {
		this.consultaPasseio = consultaPasseio;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String placa = "";
		ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
		VeiculoFrame tela = consultaCarga != null ? consultaCarga : consultaPasseio;
		if (consultaCarga != null) {
			placa = consultaCarga.pegaPlacaParaBusca();
			lista = Teste.getApp().getRepositorio().getCarrosDeCarga();
		}else if(consultaPasseio != null) {
			placa = consultaPasseio.pegaPlacaParaBusca();
			lista = Teste.getApp().getRepositorio().getCarrosDePasseio();
		}
		
		if (Teste.getApp().executaExclusaoPorPlaca(lista,placa)) {
			tela.limpaCampos();
		}

	}

}
