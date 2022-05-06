package utfpr;

public class Teste {

    public static void main(String[] args) {

        Leitura leitor = new Leitura();
        String opcaoSelecionadaPeloUsuario = "";
        do {
            opcaoSelecionadaPeloUsuario = leitor.entDados("x");
            leitor.executaOpcaoSelecionada(opcaoSelecionadaPeloUsuario);
        }while(!opcaoSelecionadaPeloUsuario.equals("7"));

    }



}
