package utfpr.app.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utfpr.app.Veiculo;
import utfpr.app.view.actions.ExcluiTodosAction;
import utfpr.app.view.actions.HideAndDisposeAction;

@SuppressWarnings("serial")
public abstract class ListaDeVeiculosFrame extends JInternalFrame {
	
	protected JPanel containerTabela;
	protected JPanel containerBotoes;
	protected JTable tabela;
	protected JButton btnImprimirTodos;
	protected JButton btnExcluirTodos;
	protected JButton btnSair;
	
	public ListaDeVeiculosFrame() {
		super("Lista de Veículos",
	              true, //resizable
	               true, //closable
	              true, //maximizable
	               true);//iconifiable  
	 
		setSize(500,300);
		
		Container principal = getContentPane();
		this.setLayout(new GridLayout(2,1));
		
		containerTabela = new JPanel(new BorderLayout());
		containerTabela.setSize(500, 200);
		configTabela();
		principal.add(containerTabela);	
		
		containerBotoes = new JPanel();
		containerBotoes.setSize(500, 200);
		
		btnImprimirTodos = new JButton("Imprimir todos");
		btnExcluirTodos = new JButton("Excluir todos");
		btnSair = new JButton("Sair");
		
		btnSair.addActionListener(new HideAndDisposeAction(this));
		btnExcluirTodos.addActionListener(new ExcluiTodosAction(this));		
		
		containerBotoes.add(btnImprimirTodos);
		containerBotoes.add(btnExcluirTodos);
		containerBotoes.add(btnSair);
		
		principal.add(containerBotoes);
	}
	
	protected void configTabela() {
		ArrayList<Veiculo> lista = this.getListaDeVeiculos();
		
		String[] colunas = Veiculo.getColumNames();
		Object[][] registros = new Object[lista.size()][colunas.length];
		
		for (int i = 0; i < registros.length; i++) {
			registros[i] = lista.get(i).asRowData();
		}		
		
		tabela = new JTable(registros, colunas);
		
		containerTabela.add(tabela, BorderLayout.CENTER);
		containerTabela.add(tabela.getTableHeader(), BorderLayout.NORTH);		
		
	}
	
	protected abstract ArrayList<Veiculo> getListaDeVeiculos();
	
	public abstract void limpaListaDeVeiculos();

}
