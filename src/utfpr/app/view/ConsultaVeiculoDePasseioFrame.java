package utfpr.app.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

import utfpr.app.Passeio;
import utfpr.app.Veiculo;
import utfpr.app.view.actions.BuscaVeiculoDePasseioPorPlacaAction;
import utfpr.app.view.actions.ExcluiVeiculoAction;

public class ConsultaVeiculoDePasseioFrame extends VeiculoDePasseioFrame {
	
	private JButton btnExcluir;
	private JButton btnConsultar;
	
	public ConsultaVeiculoDePasseioFrame() {
		super();
		
		this.btnNovo.setVisible(false);
		this.btnLimpar.setVisible(false);
		this.btnSalvar.setVisible(false);
		
		btnConsultar = new JButton("Consultar");
		btnExcluir = new JButton("Excluir");
		
		this.containerBotoes.add(btnConsultar);
		this.containerBotoes.add(btnExcluir);
		
		this.btnConsultar.addActionListener(new BuscaVeiculoDePasseioPorPlacaAction(this));
		this.btnExcluir.addActionListener(new ExcluiVeiculoAction(this));		
		
		this.bloqueiaOuDesbloqueiaCampos(true);
		
		JTextField campoConsulta = listaDeCampos.get("Placa p/ Consulta");
		campoConsulta.setEnabled(true);
		campoConsulta.setForeground(Color.red);
		
		setTitle("Busca Veículos de Passeio");
		
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
		Passeio novo = (Passeio) umVeiculo;
		listaDeCampos.get("Qtd. passageiros").setText(String.valueOf(novo.getQtdPassageiros()));
	}
	
	@Override
	protected void adicionaValidacoes() {
		//nao faz nada
	}
	

}
