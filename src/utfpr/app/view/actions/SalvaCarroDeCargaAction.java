package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utfpr.app.view.VeiculoDeCargaFrame;

public class SalvaCarroDeCargaAction implements ActionListener {

	private VeiculoDeCargaFrame owner;
	
	public SalvaCarroDeCargaAction(VeiculoDeCargaFrame tela) {
		this.owner = tela;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		owner.criaVeiculo();

	}

}
