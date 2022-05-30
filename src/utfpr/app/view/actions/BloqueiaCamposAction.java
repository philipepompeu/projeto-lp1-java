package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utfpr.app.view.VeiculoFrame;

public class BloqueiaCamposAction implements ActionListener {
	
	private VeiculoFrame owner;
	
	public BloqueiaCamposAction(VeiculoFrame tela) {
		this.owner = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//owner.limpaCampos();
		owner.bloqueiaOuDesbloqueiaCampos(true);
	}

}
