package utfpr;

public class VeicExistException extends Exception {

	public VeicExistException(String placa) {
		// TODO Auto-generated constructor stub
		
		super("J� existe um ve�culo com a placa "+ placa);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
