package utfpr.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import utfpr.app.view.TelaPrincipal;

public class Teste {
	private List<String> opcoesDeMenu;
	private Leitura leitor;
	private BDVeiculos repositorio;
	private TelaPrincipal telaPrincipal;
	
	private static Teste app;
	
	public static void main(String[] args) {
	    	
    	Teste app = Teste.getApp();
    	app.exibirMenu();
	
	}
	
	private Teste() {
        
        this.repositorio = new BDVeiculos();
        
        this.telaPrincipal = new TelaPrincipal();
	}
	
	private String solicitarOpcaoAoUsuario() throws Exception {
        int opcaoSelecionada = this.leitor.readInt("Digite a opção desejada:");

        if (opcaoSelecionada > this.opcoesDeMenu.size()) {
            throw new Exception("opção inválida.");
        }
        return String.valueOf(opcaoSelecionada);
    }
	
	private boolean usuarioDesejarRepetirOperacao(){
        boolean resultado = JOptionPane.showConfirmDialog(telaPrincipal, "Deseja repetir a operação?", "Sistema", JOptionPane.YES_NO_OPTION) == 0;       

        return resultado;
    }
	
	public Veiculo executaBuscaPorPlaca(ArrayList<Veiculo> veiculos, String placa){
        Veiculo buscado = this.buscaPlacaEmLista(placa, veiculos);

        if (buscado == null) {
            this.mostrarMensagem("Veículo não encontrado");
        }
        
        return buscado;
    }
	
	public boolean executaExclusaoPorPlaca(ArrayList<Veiculo> veiculos, String placa){
		Veiculo buscado = this.buscaPlacaEmLista(placa, veiculos);
		
		if (buscado == null) {
			this.mostrarMensagem("Veículo não encontrado");
			return false;
		}else{
			if (this.repositorio.removeVeiculo(buscado)) {
				this.mostrarMensagem("Veículo removido.");
			}
			return true;
		}
	}
	
	public boolean verificaSePlacaExiste(String placa){
        ArrayList<Veiculo> todosOsVeiculos = new ArrayList<Veiculo>();

        todosOsVeiculos.addAll(this.repositorio.getCarrosDeCarga());
        todosOsVeiculos.addAll(this.repositorio.getCarrosDePasseio());

        if (this.buscaPlacaEmLista(placa, todosOsVeiculos) != null) {
            return true;
        }

        return false;

    }
	
	private Veiculo buscaPlacaEmLista(String placa, ArrayList<Veiculo> veiculos){
        Veiculo resultado = null;
        for(Veiculo umVeiculo : veiculos){
            if (umVeiculo.getPlaca().equals(placa)) {
                resultado = umVeiculo;
                break;
            }
        }

        return resultado;
    }
	
	public void mostrarMensagem(String mensagem){
        
		JOptionPane.showMessageDialog(this.getTelaPrincipal(), mensagem, "Sistema", JOptionPane.INFORMATION_MESSAGE);
        
    }
	
	private void exibirMenu(){
		
		this.getTelaPrincipal().setVisible(true);
    }  
	
	public void adicionaVeiculo(Veiculo umVeiculo) {
		this.repositorio.adicionaVeiculo(umVeiculo);
	}

	
	public static Teste getApp() {
		if (Teste.app == null) {
			Teste.app = new Teste();
		}
		return Teste.app;
	}
	
	public BDVeiculos getRepositorio() {
		return this.repositorio;
	}
	
	public void trataException(Exception e) {
		
		JOptionPane.showMessageDialog(this.getTelaPrincipal(), e.getMessage(), "Sistema", JOptionPane.ERROR_MESSAGE);
	}

	public TelaPrincipal getTelaPrincipal() {
		return telaPrincipal;
	}

}
