package br.com.gaalv;

import br.com.gaalv.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = AppConfig.configurarAplicacao();

        view.iniciar();

        //ta passando 0 de valor no cadastro nao pode; CORRIGIDO
        //quando listar mostrar em ordem por data; CORRIGIDO
        //espaçar melhor os logs
        //fazer o loop do menu, no method menuPrincipal ou no iniciar //CORRIGIDO
        //se for no iniciar, fazer o metodo menuPrincipal retornar true se for pra continuar e false pra sair
        //ou fazer no menuPrincipal com o SAIR mudando interno o boolean responsavel pelo loop
        //melhorar a forma q as despesas sao mostradas na lista (mostrar em multilinhas? testar)
    }
}