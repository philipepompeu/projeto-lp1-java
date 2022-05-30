package utfpr.app.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import utfpr.app.Carga;
import utfpr.app.Veiculo;
import utfpr.app.view.actions.BuscaVeiculoDeCargaPorPlacaAction;
import utfpr.app.view.actions.ExcluiVeiculoAction;

@SuppressWarnings("serial")
public class ConsultaVeiculoDeCargaFrame extends VeiculoDeCargaFrame {
	private JButton btnExcluir;
	private JButton btnConsultar;
	
	public ConsultaVeiculoDeCargaFrame() {
		super();
		
		this.btnNovo.setVisible(false);
		this.btnLimpar.setVisible(false);
		this.btnSalvar.setVisible(false);
		
		btnConsultar = new JButton("Consultar");
		btnExcluir = new JButton("Excluir");
		
		this.containerBotoes.add(btnConsultar);
		this.containerBotoes.add(btnExcluir);
		
		this.btnConsultar.addActionListener(new BuscaVeiculoDeCargaPorPlacaAction(this));
		this.btnExcluir.addActionListener(new ExcluiVeiculoAction(this));
		
		this.bloqueiaOuDesbloqueiaCampos(true);
		
		JTextField campoConsulta = listaDeCampos.get("Placa p/ Consulta");
		campoConsulta.setEnabled(true);
		campoConsulta.setForeground(Color.red);
		
		setTitle("Busca Veículos de Carga");
	}
	
	@Override
	protected void adicionaCampos() {
		
		listaDeCampos.put("Placa p/ Consulta"	, new JTextField(20));
		super.adicionaCampos();
		
	}
	
	public String pegaPlacaParaBusca() {		
		return listaDeCampos.get("Placa p/ Consulta").getText();
	}
	
	@Override
	public void carregaDadosDeVeiculo(Veiculo umVeiculo) {
		super.carregaDadosDeVeiculo(umVeiculo);
		Carga novo = (Carga)umVeiculo;		
		
		listaDeCampos.get("Carga Máxima").setText(String.valueOf(novo.getCargaMax()));		
		listaDeCampos.get("Tara").setText(String.valueOf(novo.getTara()));
		
	}

}
