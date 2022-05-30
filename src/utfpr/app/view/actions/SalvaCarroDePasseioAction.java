package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utfpr.app.view.VeiculoDePasseioFrame;

public class SalvaCarroDePasseioAction implements ActionListener {

	private VeiculoDePasseioFrame owner;
	
	public SalvaCarroDePasseioAction(VeiculoDePasseioFrame tela) {
		this.owner = tela;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		owner.criaVeiculo();

	}

}
