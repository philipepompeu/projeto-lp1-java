package utfpr.app.view;

import utfpr.app.Passeio;
import utfpr.app.Teste;
import utfpr.app.VelocException;
import utfpr.app.view.actions.BloqueiaCamposAction;
import utfpr.app.view.actions.SalvaCarroDePasseioAction;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class VeiculoDePasseioFrame extends VeiculoFrame {
	
	public VeiculoDePasseioFrame() {
		super();		
		btnSalvar.addActionListener(new SalvaCarroDePasseioAction(this));		
		btnSalvar.addActionListener(new BloqueiaCamposAction(this));
		this.setTitle("Novo veículo de passeio");
	}
	
	@Override
	protected void adicionaCampos() {
		super.adicionaCampos();		
		listaDeCampos.put("Qtd. passageiros"	, new JTextField(20));
		
	}
	
	public Passeio criaVeiculo() {
		
		Passeio umCarro = new Passeio();
		
		try {
			this.carregaCamposDeVeiculo(umCarro);
			int passageiros = Integer.valueOf(listaDeCampos.get("Qtd. passageiros").getText());
			umCarro.setQtdPassageiros(passageiros);			
			Teste.getApp().adicionaVeiculo(umCarro);
			
		} catch (VelocException e) {
			Teste.getApp().trataException(e);
		}
		
		return umCarro;
		
	}
}
