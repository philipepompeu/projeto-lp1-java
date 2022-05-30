package utfpr.app.view;

import javax.swing.JTextField;

import utfpr.app.Carga;
import utfpr.app.Teste;
import utfpr.app.VelocException;
import utfpr.app.view.actions.BloqueiaCamposAction;
import utfpr.app.view.actions.SalvaCarroDeCargaAction;

@SuppressWarnings("serial")
public class VeiculoDeCargaFrame extends VeiculoFrame {
	
	public VeiculoDeCargaFrame() {
		super();
		btnSalvar.addActionListener(new SalvaCarroDeCargaAction(this));
		btnSalvar.addActionListener(new BloqueiaCamposAction(this));
		
		this.setTitle("Novo veículo de carga");
	}
	
	@Override
	protected void adicionaCampos() {
		super.adicionaCampos();		
		listaDeCampos.put("Carga Máxima"	, new JTextField(20));
		listaDeCampos.put("Tara"			, new JTextField(20));
		
	}
	
	public Carga criaVeiculo() {
		
		Carga umCarro = new Carga();
		
		try {
			this.carregaCamposDeVeiculo(umCarro);
			int cargaMax = Integer.valueOf(listaDeCampos.get("Carga Máxima").getText());
			umCarro.setCargaMax(cargaMax);
			int tara = Integer.valueOf(listaDeCampos.get("Tara").getText());
			umCarro.setTara(tara);
			
			Teste.getApp().adicionaVeiculo(umCarro);
			
		} catch (VelocException e) {
			Teste.getApp().trataException(e);
		}
		
		return umCarro;
		
	}
}
