package utfpr.app.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import utfpr.app.Teste;

public class TelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9023986022950484402L;
	private List<String> opcoesDeMenu;;
	private JDesktopPane container;
	private JMenuBar barraDeMenu;
	private JMenu menuOpcoes;
	private VeiculoDePasseioFrame cadastroDeCarroDePasseio;
	private VeiculoDeCargaFrame cadastroDeCarroDeCarga;
	private ListaVeiculosDePasseioFrame listaVeiculosDePasseio;
	private ListaDeVeiculosDeCargaFrame listaVeiculosDeCarga;
	private ConsultaVeiculoDePasseioFrame consultaVeiculoDePasseio;
	private ConsultaVeiculoDeCargaFrame consultaVeiculoDeCarga;

	public TelaPrincipal() {
		this.opcoesDeMenu = new ArrayList<String>();
        this.opcoesDeMenu.add("Cadastrar veículo de Passeio");
        this.opcoesDeMenu.add("Cadastrar veículo de Carga");
        this.opcoesDeMenu.add("Imprimir Todos os veículos de Passeio");
        this.opcoesDeMenu.add("Imprimir Todos os veículos de Carga");
        this.opcoesDeMenu.add("Buscar veículo de Passeio pela Placa");
        this.opcoesDeMenu.add("Buscar veículo de Carga pela Placa");
                
        this.opcoesDeMenu.add("Sair do Sistema");

		this.setSize(1000, 600);
		this.setTitle("Gestão de Automóveis");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.container = new JDesktopPane();
		this.add(container);
		this.container.setSize(this.getSize());
		
		
		this.barraDeMenu = new JMenuBar();
		this.setJMenuBar(barraDeMenu);
		
		this.menuOpcoes = new JMenu("Menu");
		barraDeMenu.add(menuOpcoes);		
		
		for (String opcaoDoMenu : opcoesDeMenu) {
			JMenuItem itemDoMenu = new JMenuItem(opcaoDoMenu);
			
			itemDoMenu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JMenuItem itemClicado = (JMenuItem) e.getSource();					
					TelaPrincipal.executaOpcaoSelecionada(itemClicado.getText());
					
				}
			});
			menuOpcoes.add(itemDoMenu);
		}		
		
	}
	
	public static TelaPrincipal getInstance() {
		
		return Teste.getApp().getTelaPrincipal();
	}
	
	public static void executaOpcaoSelecionada(String opcaoSelecionada) {
		TelaPrincipal tela = TelaPrincipal.getInstance();
		
		String opcao = String.valueOf(tela.opcoesDeMenu.indexOf(opcaoSelecionada));
		
		tela.executaAcaoDoMenu(opcao);
	}
	
	private void executaAcaoDoMenu(String opcao) 
	{
		if (opcao.equals("0")) {
			this.incluiVeiculoDePasseio();			
		}else if(opcao.equals("1")) {
			this.incluiVeiculoDeCarga();
		}else if(opcao.equals("2")) {
			this.listaVeiculosDePasseio();
		}else if(opcao.equals("3")) {
			this.listaVeiculosDeCarga();
		}else if(opcao.equals("4")) {
			this.consultaVeiculoPelaPlaca(false);
		}else if(opcao.equals("5")) {
			this.consultaVeiculoPelaPlaca(true);
		}else if(opcao.equals("6")) {
			this.setVisible(false);
			this.dispose();
		}
	}

	private void consultaVeiculoPelaPlaca(boolean isCarga) {
		JInternalFrame tela;
		if (isCarga) {
			tela = this.getConsultaVeiculoDeCarga();
		}else {
			tela = this.getConsultaVeiculoDePasseio();
		}
		
		if (!tela.isVisible()) {			
			tela.setVisible(true);
			this.container.add(tela);
		}		
	}

	private void listaVeiculosDeCarga() {
		ListaDeVeiculosFrame tela = TelaPrincipal.getInstance().getListaVeiculosDeCarga();
		
		if (!tela.isVisible()) {			
			tela.setVisible(true);
			this.container.add(tela);
		}
		
	}

	private void listaVeiculosDePasseio() {
		
		ListaDeVeiculosFrame tela = TelaPrincipal.getInstance().getListaVeiculosDePasseio();
		
		if (!tela.isVisible()) {			
			tela.setVisible(true);
			this.container.add(tela);
		}
		
	}

	private void incluiVeiculoDePasseio() {
		VeiculoDePasseioFrame tela = TelaPrincipal.getInstance().getCadastroDeCarroDePasseio();
		
		if (!tela.isVisible()) {			
			tela.setVisible(true);
			this.container.add(tela);
		}
	}
	
	private void incluiVeiculoDeCarga() {
		VeiculoDeCargaFrame tela = TelaPrincipal.getInstance().getCadastroDeCarroDeCarga();
		
		if (!tela.isVisible()) {			
			tela.setVisible(true);
			this.container.add(tela);
		}
		
	}

	private VeiculoDeCargaFrame getCadastroDeCarroDeCarga() {
		
		if (cadastroDeCarroDeCarga == null) {
			cadastroDeCarroDeCarga = new VeiculoDeCargaFrame();
		}
		return cadastroDeCarroDeCarga;
	}

	public VeiculoDePasseioFrame getCadastroDeCarroDePasseio() {
		if (cadastroDeCarroDePasseio == null) {
			cadastroDeCarroDePasseio = new VeiculoDePasseioFrame();
		}
		
		return cadastroDeCarroDePasseio;
	}

	private ListaVeiculosDePasseioFrame getListaVeiculosDePasseio() {
		if (listaVeiculosDePasseio == null) {
			listaVeiculosDePasseio = new ListaVeiculosDePasseioFrame();
		}
		return listaVeiculosDePasseio;
	}
	private ListaDeVeiculosDeCargaFrame getListaVeiculosDeCarga() {
		if (listaVeiculosDeCarga == null) {
			listaVeiculosDeCarga = new ListaDeVeiculosDeCargaFrame();
		}
		return listaVeiculosDeCarga;
	}

	private ConsultaVeiculoDeCargaFrame getConsultaVeiculoDeCarga() {
		if (this.consultaVeiculoDeCarga == null) {
			this.consultaVeiculoDeCarga = new ConsultaVeiculoDeCargaFrame();
		}
		return consultaVeiculoDeCarga;
	}

	private ConsultaVeiculoDePasseioFrame getConsultaVeiculoDePasseio() {
		if (this.consultaVeiculoDePasseio == null) {
			this.consultaVeiculoDePasseio = new ConsultaVeiculoDePasseioFrame();
		}
		return consultaVeiculoDePasseio;
	}
}
