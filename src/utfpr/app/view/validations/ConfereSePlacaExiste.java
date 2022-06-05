package utfpr.app.view.validations;

import javax.swing.JTextField;

import utfpr.app.Teste;
import utfpr.app.VeicExistException;

public class ConfereSePlacaExiste implements Validacao {
	private String ultimoValor;

	@Override
	public boolean isValid(JTextField campo) {
		String placa = campo.getText();
		
		this.ultimoValor = placa;
		return !(Teste.getApp().verificaSePlacaExiste(placa));
	}

	@Override
	public String getFailMessage() {		
		return new VeicExistException(ultimoValor).getMessage();
	}

}
