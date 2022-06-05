package utfpr.app.view;

import utfpr.app.Passeio;
import utfpr.app.Teste;
import utfpr.app.VelocException;
import utfpr.app.view.actions.BloqueiaCamposAction;
import utfpr.app.view.actions.SalvaVeiculoAction;
import utfpr.app.view.validations.ValidaSeInteiro;

import javax.swing.JTextField;


@SuppressWarnings("serial")
public class VeiculoDePasseioFrame extends VeiculoFrame implements CriadorDeVeiculo {
	
	public VeiculoDePasseioFrame() {
		super();		
		btnSalvar.addActionListener(new SalvaVeiculoAction(this));		
		btnSalvar.addActionListener(new BloqueiaCamposAction(this));
		this.setTitle("Novo veículo de passeio");		
	}
	
	@Override
	protected void adicionaCampos() {
		super.adicionaCampos();		
		listaDeCampos.put("Qtd. passageiros"	, new JTextField(20));
		
	}
	
	@Override
	protected void adicionaValidacoes() {
		super.adicionaValidacoes();		
		this.adicionaValidacao("Qtd. passageiros", new ValidaSeInteiro());
	}
	
	public Passeio criaVeiculo() {		
		
		try {
			Passeio umCarro = new Passeio();
			this.carregaCamposDeVeiculo(umCarro);
			int passageiros = Integer.valueOf(listaDeCampos.get("Qtd. passageiros").getText());
			umCarro.setQtdPassageiros(passageiros);
			
			return umCarro;
		} catch (VelocException e) {
			Teste.getApp().trataException(e);
			return null;
		}
		
		
	}
}
