package utfpr.app.view.validations;

import javax.swing.JTextField;

import utfpr.app.VelocException;

public class ValidaVelocMax implements Validacao {
	private String mensagemAdicional;
	@Override
	public boolean isValid(JTextField campo) {
		String valor = campo.getText();
		
		try {
			
			float velocMax = Float.valueOf(valor);
			
			if (velocMax < 80 || velocMax > 110) {
				throw new VelocException();
			}
			
			return true;

		} catch (Exception e) {
			this.mensagemAdicional = e.getMessage();
			return false;
		}
	}

	@Override
	public String getFailMessage() {
		
		return mensagemAdicional.isEmpty() ? "Valor inválido" : mensagemAdicional;
	}

}
