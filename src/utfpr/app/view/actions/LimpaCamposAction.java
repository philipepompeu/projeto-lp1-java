package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utfpr.app.view.VeiculoFrame;

public class LimpaCamposAction implements ActionListener {
	
	private VeiculoFrame owner;
	
	public LimpaCamposAction(VeiculoFrame tela) {
		this.owner = tela;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		owner.limpaCampos();
	}

}
