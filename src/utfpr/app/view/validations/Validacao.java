package utfpr.app.view.validations;

import javax.swing.JTextField;

public interface Validacao {
	
	public boolean isValid(JTextField campo);
	
	public String getFailMessage();

}
