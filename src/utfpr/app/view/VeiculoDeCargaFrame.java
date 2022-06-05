package utfpr.app.view;

import javax.swing.JTextField;

import utfpr.app.Carga;
import utfpr.app.Teste;
import utfpr.app.VelocException;
import utfpr.app.view.actions.BloqueiaCamposAction;
import utfpr.app.view.actions.SalvaVeiculoAction;
import utfpr.app.view.validations.ValidaSeInteiro;

@SuppressWarnings("serial")
public class VeiculoDeCargaFrame extends VeiculoFrame implements CriadorDeVeiculo {
	
	public VeiculoDeCargaFrame() {
		super();
		btnSalvar.addActionListener(new SalvaVeiculoAction(this));
		btnSalvar.addActionListener(new BloqueiaCamposAction(this));
		
		this.setTitle("Novo veículo de carga");
	}
	
	@Override
	protected void adicionaCampos() {
		super.adicionaCampos();		
		listaDeCampos.put("Carga Máxima"	, new JTextField(20));
		listaDeCampos.put("Tara"			, new JTextField(20));
		
	}
	
	@Override
	protected void adicionaValidacoes() {
		super.adicionaValidacoes();
		this.adicionaValidacao("Carga Máxima", new ValidaSeInteiro());
		this.adicionaValidacao("Tara", new ValidaSeInteiro());
	}
	
	public Carga criaVeiculo() {		
		
		try {
			Carga umCarro = new Carga();
			this.carregaCamposDeVeiculo(umCarro);
			int cargaMax = Integer.valueOf(listaDeCampos.get("Carga Máxima").getText());
			umCarro.setCargaMax(cargaMax);
			int tara = Integer.valueOf(listaDeCampos.get("Tara").getText());
			umCarro.setTara(tara);
			return umCarro;			
		} catch (VelocException e) {
			Teste.getApp().trataException(e);
			
			return null;
		}
		
		
	}
}
