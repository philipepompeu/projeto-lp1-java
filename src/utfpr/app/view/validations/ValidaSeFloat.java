package utfpr.app.view.validations;

import javax.swing.JTextField;

public class ValidaSeFloat implements Validacao {

	@Override
	public boolean isValid(JTextField campo) {
		String valorDigitado = campo.getText();
		
		try {
			Float.valueOf(valorDigitado);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String getFailMessage() {
		// TODO Auto-generated method stub
		return "Informe um valor numérico válido";
	}

}
