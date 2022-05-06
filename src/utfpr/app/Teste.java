package utfpr.app;

import java.util.ArrayList;
import java.util.List;

public class Teste {
	private List<String> opcoesDeMenu;
	private Leitura leitor;
	private BDVeiculos repositorio;
	
	public static void main(String[] args) {
	    	
    	Teste app = new Teste();
    	
        String opcaoSelecionadaPeloUsuario = "";
		do {
		    
			app.exibirMenu();
			try {
				opcaoSelecionadaPeloUsuario = app.solicitarOpcaoAoUsuario();
				
				app.executaOpcaoSelecionada(opcaoSelecionadaPeloUsuario);
			} catch (Exception e) {
				app.mostrarMensagem(e.getMessage());
			}
		    
		}while(!opcaoSelecionadaPeloUsuario.equals("9"));
	
	}
	
	public Teste() {

		this.opcoesDeMenu = new ArrayList<String>();
        this.opcoesDeMenu.add("1. Cadastrar ve�culo de Passeio");
        this.opcoesDeMenu.add("2. Cadastrar ve�culo de Carga");
        this.opcoesDeMenu.add("3. Imprimir Todos os ve�culos de Passeio");
        this.opcoesDeMenu.add("4. Imprimir Todos os ve�culos de Carga");
        this.opcoesDeMenu.add("5. Imprimir ve�culo de Passeio pela Placa");
        this.opcoesDeMenu.add("6. Imprimir ve�culo de Carga pela Placa");
        this.opcoesDeMenu.add("7. Exclui ve�culo de Passeio pela Placa");
        this.opcoesDeMenu.add("8. Exclui ve�culo de Carga pela Placa");        
        this.opcoesDeMenu.add("9. Sair do Sistema");
        
        this.leitor = new Leitura();
        this.repositorio = new BDVeiculos();
	}
	
	private String solicitarOpcaoAoUsuario() throws Exception {
        int opcaoSelecionada = this.leitor.readInt("Digite a op��o desejada:");

        if (opcaoSelecionada > this.opcoesDeMenu.size()) {
            throw new Exception("op��o inv�lida.");
        }
        return String.valueOf(opcaoSelecionada);
    }
	
	public void executaOpcaoSelecionada(String opcao){

        switch (opcao){
            case "1":
                this.cadastraVeiculo(Passeio.class);
                break;
            case "2":
                this.cadastraVeiculo(Carga.class);
                break;
            case "3":
            	this.imprimeListaDeVeiculos(this.repositorio.getCarrosDePasseio());
                break;
            case "4":
                this.imprimeListaDeVeiculos(this.repositorio.getCarrosDeCarga());
                break;
            case "5":            	
                this.executaBuscaPorPlaca(this.repositorio.getCarrosDePasseio());
                break;
            case "6":
                this.executaBuscaPorPlaca(this.repositorio.getCarrosDeCarga());
                break;
            case "7":
            	this.executaExclusaoPorPlaca(this.repositorio.getCarrosDePasseio());
            	break;
            case "8":
            	this.executaExclusaoPorPlaca(this.repositorio.getCarrosDeCarga());
            	break;
            case "9":
                this.mostrarMensagem("Saindo da aplica��o.");
                break;

        }
    }
	
	private boolean usuarioDesejarRepetirOperacao(){
        boolean resultado = this.leitor.readInt("Deseja repetir a opera��o?(1=Sim;2=N�o)") == 1;

        return resultado;
    }
	
	private void executaBuscaPorPlaca(ArrayList<Veiculo> veiculos){
        String placa = this.solicitaPlaca();
        Veiculo buscado = this.buscaPlacaEmLista(placa, veiculos);

        if (buscado == null) {
            this.mostrarMensagem("Ve�culo n�o encontrado");
        }else{
            this.mostrarMensagem("Carro encontrado, dados abaixo:");
            this.mostrarMensagem(buscado.toString());
        }
    }
	
	private void executaExclusaoPorPlaca(ArrayList<Veiculo> veiculos){
		String placa = this.solicitaPlaca();
		Veiculo buscado = this.buscaPlacaEmLista(placa, veiculos);
		
		if (buscado == null) {
			this.mostrarMensagem("Ve�culo n�o encontrado");
		}else{
			if (this.repositorio.removeVeiculo(buscado)) {
				this.mostrarMensagem("Ve�culo removido.");
			}
		}
	}
	
	private void imprimeListaDeVeiculos(ArrayList<Veiculo> veiculos){
        for(Veiculo umVeiculo : veiculos){
            System.out.println(umVeiculo.toString());
            System.out.println("#########################");
        }
    }
	
	private boolean verificaSePlacaExiste(String placa){
        ArrayList<Veiculo> todosOsVeiculos = new ArrayList<Veiculo>();

        todosOsVeiculos.addAll(this.repositorio.getCarrosDeCarga());
        todosOsVeiculos.addAll(this.repositorio.getCarrosDePasseio());

        if (this.buscaPlacaEmLista(placa, todosOsVeiculos) != null) {
            return true;
        }

        return false;

    }
	
	public Veiculo buscaPlacaEmLista(String placa, ArrayList<Veiculo> veiculos){
        Veiculo resultado = null;
        for(Veiculo umVeiculo : veiculos){
            if (umVeiculo.getPlaca().equals(placa)) {
                resultado = umVeiculo;
                break;
            }
        }

        return resultado;
    }
	
	private String solicitaPlaca() {
        String placa = this.leitor.readString("Informe a placa para busca:");
        return placa;
    }
    
    private void cadastraVeiculo(Class<? extends Veiculo> classe){

		do {			
			try {
				
				boolean isCarga = classe.equals(Carga.class);				
				Veiculo umVeiculo = this.leitor.buildVeiculo(isCarga);
				
				if (this.verificaSePlacaExiste(umVeiculo.getPlaca())) {
					throw new VeicExistException(umVeiculo.getPlaca());
				}
				this.repositorio.adicionaVeiculo(umVeiculo);
	        } catch (Exception e) {
	            this.mostrarMensagem(e.getMessage());
	        }
		}while (this.usuarioDesejarRepetirOperacao());
        
    }
	
	private void mostrarMensagem(String mensagem){
        this.leitor.mostrarMensagem(mensagem);
    }
	
	private void exibirMenu(){
        for(String opcao : this.opcoesDeMenu){
            this.mostrarMensagem(opcao);
        }
    }  



}
