package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utfpr.app.Teste;
import utfpr.app.Veiculo;
import utfpr.app.view.CriadorDeVeiculo;

public class SalvaVeiculoAction implements ActionListener {

	private CriadorDeVeiculo criador;
	
	public SalvaVeiculoAction(CriadorDeVeiculo tela) {
		this.criador = tela;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Veiculo umCarro = criador.criaVeiculo();
		
		if (umCarro != null) {
			Teste.getApp().adicionaVeiculo(umCarro);			
		}
		

	}

}
