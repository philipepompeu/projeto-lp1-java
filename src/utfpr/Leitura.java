package utfpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leitura {
    private Scanner scanner;
    private List<String> opcoesDeMenu;
    private ArrayList<Veiculo> carrosDeCarga;
    private ArrayList<Veiculo> carrosDePasseio;

    public Leitura(){
        this.scanner = new Scanner(System.in);
        this.opcoesDeMenu = new ArrayList<String>();
        this.opcoesDeMenu.add("1. Cadastrar veículo de Passeio");
        this.opcoesDeMenu.add("2. Cadastrar veículo de Carga");
        this.opcoesDeMenu.add("3. Imprimir Todos os veículos de Passeio");
        this.opcoesDeMenu.add("4. Imprimir Todos os veículos de Carga");
        this.opcoesDeMenu.add("5. Imprimir veículo de Passeio pela Placa");
        this.opcoesDeMenu.add("6. Imprimir veículo de Carga pela Placa");
        this.opcoesDeMenu.add("7. Sair do Sistema");

        this.carrosDeCarga = new ArrayList<Veiculo>();
        this.carrosDePasseio = new ArrayList<Veiculo>();
    }

    public String entDados(String c) {

        this.exibirMenu();

        try {
            return this.solicitarOpcaoAoUsuario();
        } catch (Exception e) {
            this.mostrarMensagem(e.getMessage());
        }

        return "0";
    }

    private void exibirMenu(){
        for(String opcao : this.opcoesDeMenu){
            this.mostrarMensagem(opcao);
        }
    }

    private String solicitarOpcaoAoUsuario() throws Exception {
        int opcaoSelecionada = this.readInt("Digite a opção desejada:");

        if (opcaoSelecionada > this.opcoesDeMenu.size()) {
            throw new Exception("opção inválida.");
        }
        return String.valueOf(opcaoSelecionada);
    }

    private int readInt(String mensagem){
        this.mostrarMensagem(mensagem);
        int resultado = this.scanner.nextInt();
        this.scanner.nextLine();//limpa \n
        return resultado;
    }

    private float readFloat(String mensagem){
        this.mostrarMensagem(mensagem);
        return this.scanner.nextFloat();
    }

    private String readString(String mensagem){

        this.mostrarMensagem(mensagem);

        return this.scanner.nextLine();
    }

    private void mostrarMensagem(String mensagem){
        System.out.println(mensagem);
    }

    public void executaOpcaoSelecionada(String opcao){

        switch (opcao){
            case "1":
                this.cadastraVeiculoDePasseio();
                break;
            case "2":
                this.cadastraVeiculoDeCarga();
                break;
            case "3":
                this.imprimeListaDeVeiculos(this.carrosDePasseio);
                break;
            case "4":
                this.imprimeListaDeVeiculos(this.carrosDeCarga);
                break;
            case "5":
                this.executaBuscaPorPlaca(this.carrosDePasseio);
                break;
            case "6":
                this.executaBuscaPorPlaca(this.carrosDeCarga);
                break;
            case "7":
                this.mostrarMensagem("Saindo da aplicação.");
                break;

        }
    }

    private String solicitaPlaca() {
        String placa = this.readString("Informe a placa para busca:");

        return placa;

    }

    private void executaBuscaPorPlaca(ArrayList<Veiculo> veiculos){
        String placa = this.solicitaPlaca();
        Veiculo buscado = this.buscaPlacaEmLista(placa, veiculos);

        if (buscado == null) {
            this.mostrarMensagem("Veículo não encontrado");
        }else{
            this.mostrarMensagem("Carro encontrado, dados abaixo:");
            this.mostrarMensagem(buscado.toString());
        }
    }

    private void cadastraVeiculoDePasseio(){

        try {
            do {
                Passeio umVeiculo = (Passeio)this.buildVeiculo(false);
                this.adicionaVeiculoEmLista(umVeiculo, carrosDePasseio);
            }while (this.usuarioDesejarRepetirOperacao());
        } catch (Exception e) {
            this.mostrarMensagem(e.getMessage());
        }

    }

    private void cadastraVeiculoDeCarga(){
        try {
            do {
                Carga umVeiculo = (Carga)this.buildVeiculo(true);
                this.adicionaVeiculoEmLista(umVeiculo, this.carrosDeCarga);
            }while(this.usuarioDesejarRepetirOperacao());
        }catch (Exception e){
            this.mostrarMensagem(e.getMessage());
        }
    }

    private boolean usuarioDesejarRepetirOperacao(){
        boolean resultado = this.readInt("Deseja repetir a operação?(1=Sim;2=Não)") == 1;

        return resultado;
    }

    private void adicionaVeiculoEmLista(Veiculo carro, ArrayList<Veiculo> lista) throws Exception {

        if (lista.size()+1 > 5) throw new Exception("Quantidade máxima de veículos atingida.");

        lista.add(carro);
    }
    private void imprimeListaDeVeiculos(ArrayList<Veiculo> veiculos){
        for(Veiculo umVeiculo : veiculos){
            System.out.println(umVeiculo.toString());
        }
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

    private boolean verificaSePlacaExiste(String placa){
        ArrayList<Veiculo> todosOsVeiculos = new ArrayList<Veiculo>();

        todosOsVeiculos.addAll(this.carrosDeCarga);
        todosOsVeiculos.addAll(this.carrosDePasseio);

        if (this.buscaPlacaEmLista(placa, todosOsVeiculos) != null) {
            return true;
        }

        return false;

    }

    private Veiculo buildVeiculo(boolean isCarga) throws Exception {
        System.out.println("Informe abaixo os dados do próximo veículo: ");
        String marca = this.readString("Qual a marca?");
        String modelo = this.readString("Qual o modelo?");
        String   cor = this.readString("Qual a cor?");
        String placa = this.readString("Qual a placa?");


        if (this.verificaSePlacaExiste(placa)) {
            throw new Exception("veículo já cadastrado.");
        }

        int qtdRodas = this.readInt("Qual a quantidade de rodas?");
        int potencia = this.readInt("Qual a potência(cv) do motor?");
        int km = this.readInt("Qual a quilometragem?");

        Veiculo result = isCarga ? new Carga() : new Passeio();
        result.setMarca(marca);
        result.setModelo(modelo);
        result.setCor(cor);
        result.setQtdRodas(qtdRodas);
        result.setPlaca(placa);
        result.setMotor(km,potencia);

        if (isCarga) {
            int tara = this.readInt("Qual a tara(peso) do veículo em kg?");
            ((Carga) result).setTara(tara);
            int cargaMax = this.readInt("Qual a carga máxima do veículo em kg?");
            ((Carga)result).setCargaMax(cargaMax);
        }else{
            int qtdPassageiros = this.readInt("Qual a quantidade de passageiros?");
            ((Passeio)result).setQtdPassageiros(qtdPassageiros);
        }

        float velocMax = this.readFloat("Qual a velocidade maxima do veículo?");
        result.setVelocMax(velocMax);

        return result;
    }
}