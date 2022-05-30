package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utfpr.app.view.ListaDeVeiculosFrame;

public class ExcluiTodosAction implements ActionListener {
	
	ListaDeVeiculosFrame tela;
	
	public ExcluiTodosAction(ListaDeVeiculosFrame tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tela.limpaListaDeVeiculos();

	}

}
