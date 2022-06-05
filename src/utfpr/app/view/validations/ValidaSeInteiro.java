package utfpr.app.view.validations;

import javax.swing.JTextField;

public class ValidaSeInteiro implements Validacao {

	@Override
	public boolean isValid(JTextField campo) {
		String valorDigitado = campo.getText();
		
		try {
			Integer.valueOf(valorDigitado);
			return true;
		} catch (Exception e) {
			return false;
		}		
		
	}

	@Override
	public String getFailMessage() {
		return "Valor não é um inteiro válido";
	}

}
