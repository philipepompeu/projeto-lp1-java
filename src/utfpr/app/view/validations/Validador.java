package utfpr.app.view.validations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

import utfpr.app.Teste;

public class Validador extends InputVerifier {
	private ArrayList<Validacao> validacoes;
	
	public Validador() {
		// TODO Auto-generated constructor stub
		validacoes = new ArrayList<Validacao>();
	}

	@Override
	public boolean verify(JComponent input) {
		JTextField campo = (JTextField) input;
		String placa = campo.getText();
		
		for (Validacao validacao : validacoes) {
			if (!validacao.isValid(campo)) {
				Teste.getApp().trataException(new Exception(validacao.getFailMessage()));
				return false;
			}
		}
		
		return true;
		
	}
	
	public void adicionaValidcao(Validacao a) {
		this.validacoes.add(a);
	}

}
