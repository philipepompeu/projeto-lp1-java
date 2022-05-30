package utfpr.app.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utfpr.app.Veiculo;
import utfpr.app.VelocException;
import utfpr.app.view.actions.DesbloqueiaCamposAction;
import utfpr.app.view.actions.HideAndDisposeAction;
import utfpr.app.view.actions.LimpaCamposAction;



public abstract class VeiculoFrame extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1313192574353655148L;
	protected JPanel containerCampos;
	protected JPanel containerBotoes;
	protected LinkedHashMap<String, JTextField> listaDeCampos;
	protected JButton btnSalvar;
	protected JButton btnLimpar;
	protected JButton btnSair;
	protected JButton btnNovo;
	
	public VeiculoFrame() {
		// TODO Auto-generated constructor stub
		super("Novo Veículo",
	              true, //resizable
	               true, //closable
	              true, //maximizable
	               true);//iconifiable  
	 
		setSize(500,300);
		Container principal = getContentPane();
		this.setLayout(new GridLayout(2,1));
		containerCampos = new JPanel();
		containerCampos.setSize(500, 200);
		 
		principal.add(containerCampos);
		 
		this.listaDeCampos = new LinkedHashMap<String, JTextField>();//linkedHashMap é ordenada pela ordem de inserção
		 
		this.adicionaCampos();
		
		containerCampos.setLayout(new GridLayout(listaDeCampos.size(),2));
         
		Iterator lista =  listaDeCampos.entrySet().iterator();
		
		while(lista.hasNext()) {
			Entry<String, JTextField> entry = (Entry)lista.next();			
			addTextFieldComLabel(entry.getValue(), entry.getKey());
		}		
        
		
		this.adicionaBotoes(principal);
		
	}

	private void adicionaBotoes(Container mainContainer) {
		containerBotoes = new JPanel();
		containerBotoes.setSize(500, 100);
		mainContainer.add(containerBotoes);
		
		btnSalvar = new JButton("Cadastrar");		
		btnLimpar = new JButton("Limpar");		
		btnNovo = new JButton("Novo");
		btnSair = new JButton("Sair");
		containerBotoes.add(btnSalvar);
		containerBotoes.add(btnLimpar);
		containerBotoes.add(btnNovo);
		containerBotoes.add(btnSair);
		
		btnLimpar.addActionListener(new LimpaCamposAction(this));		
		btnSair.addActionListener(new HideAndDisposeAction(this));
		
		btnNovo.addActionListener(new LimpaCamposAction(this));
		btnNovo.addActionListener(new DesbloqueiaCamposAction(this));
		
	}

	protected void adicionaCampos() {
		
		listaDeCampos.put("Marca"	, new JTextField(20));
		listaDeCampos.put("Modelo"	, new JTextField(20));
		listaDeCampos.put("Cor"		, new JTextField(20));
		listaDeCampos.put("Placa"	, new JTextField(20));
		listaDeCampos.put("Qtd. rodas"	, new JTextField(20));
		listaDeCampos.put("Potência(cv)"	, new JTextField(20));
		listaDeCampos.put("Quilometragem"	, new JTextField(20));
		listaDeCampos.put("Velocidade Máxima"	, new JTextField(20));

	}
	
	protected void addTextFieldComLabel(JTextField campo, String label) {
		
		JLabel lblCampo = new JLabel(label+":");
		lblCampo.setLabelFor(campo);
		
		containerCampos.add(lblCampo);
		containerCampos.add(campo);
	}
	
	public void limpaCampos() {
		Iterator lista =  listaDeCampos.entrySet().iterator();
		
		while(lista.hasNext()) {
			Entry<String, JTextField> entry = (Entry)lista.next();
			JTextField campo = entry.getValue();
			campo.setText("");
		}
		
	}
	
	public void bloqueiaOuDesbloqueiaCampos(boolean bloqueia) {
		Iterator lista =  listaDeCampos.entrySet().iterator();
		
		while(lista.hasNext()) {
			Entry<String, JTextField> entry = (Entry)lista.next();
			JTextField campo = entry.getValue();
			campo.setEnabled(!bloqueia);			
		}
	}
	
	protected void carregaCamposDeVeiculo(Veiculo umCarro) throws VelocException {
		
		umCarro.setMarca(listaDeCampos.get("Marca").getText());
		umCarro.setModelo(listaDeCampos.get("Modelo").getText());
		umCarro.setCor(listaDeCampos.get("Cor").getText());
		umCarro.setPlaca(listaDeCampos.get("Placa").getText());
		
		int qtdRodas = Integer.valueOf(listaDeCampos.get("Qtd. rodas").getText());
		umCarro.setQtdRodas(qtdRodas);
		
		int potencia = Integer.valueOf(listaDeCampos.get("Potência(cv)").getText());
        int km = Integer.valueOf(listaDeCampos.get("Quilometragem").getText());
		umCarro.setMotor(km, potencia);
        
		float velocMax = Float.valueOf(listaDeCampos.get("Velocidade Máxima").getText());
		
		umCarro.setVelocMax(velocMax);	
		
	}
	
	public void carregaDadosDeVeiculo(Veiculo umVeiculo) {
		if (umVeiculo == null) {
			return;
		}
		
		listaDeCampos.get("Marca").setText(umVeiculo.getMarca());
		listaDeCampos.get("Modelo").setText(umVeiculo.getModelo());
		listaDeCampos.get("Cor").setText(umVeiculo.getCor());
		listaDeCampos.get("Placa").setText(umVeiculo.getPlaca());
		
		listaDeCampos.get("Qtd. rodas").setText(String.valueOf(umVeiculo.getQtdRodas()));
		listaDeCampos.get("Potência(cv)").setText(String.valueOf(umVeiculo.getPotencia()));
		listaDeCampos.get("Quilometragem").setText(String.valueOf(umVeiculo.getKm()));
		
	}

}
