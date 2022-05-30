package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utfpr.app.view.VeiculoFrame;

public class DesbloqueiaCamposAction implements ActionListener {

	private VeiculoFrame owner;
	
	public DesbloqueiaCamposAction(VeiculoFrame tela) {
		this.owner = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		owner.bloqueiaOuDesbloqueiaCampos(false);
	}

}
