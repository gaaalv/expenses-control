package main.java.br.com.gaalv.view;

import main.java.br.com.gaalv.controller.Controller;
import main.java.br.com.gaalv.model.Despesa;
import main.java.br.com.gaalv.model.enums.TipoDespesa;
import main.java.br.com.gaalv.model.enums.TipoPagamento;
import main.java.br.com.gaalv.view.enums.EscolhaMenuPrincipal;
import main.java.br.com.gaalv.view.enums.OpcaoMenu;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public class ConsoleView {
    private final Controller controller;
    private final InputReader inputReader;

    private record DadosDespesa(LocalDate data, String descricao, BigDecimal valor,
                                TipoPagamento pagamento, TipoDespesa tipo, String obs) {}

    public ConsoleView(Controller controller, InputReader inputReader) {
        this.controller = controller;
        this.inputReader =  inputReader;
    }

    public void iniciar() {
        System.out.println("=== MVP PARA GERENCIAMENTO DE DESPESAS ===");
        try{
            while(true) {
                EscolhaMenuPrincipal input = processarMenuPrincipal();

                switch (input) {
                    case ADICIONAR -> cadastroDespesa();
                    case REMOVER -> removerDespesa();
                    case ATUALIZAR -> atualizarDespesa();
                    case LISTAR -> listarDespesas();
                    case SAIR -> {
                        System.out.println("Saindo...");
                        return;
                    }
                }
            }
        } catch(Exception e) {
            System.out.println("[VIEW]: Erro " + e.getMessage());
        } finally {
            inputReader.encerrarScanner();
        }
    }

    public EscolhaMenuPrincipal processarMenuPrincipal() {
        System.out.println("Selecione a ação desejada: (Digite o ID entre []");
        return lerEnumAteValido(
                EscolhaMenuPrincipal.values(),
                inputReader::lerEscolhaMenuPrincipal);
    }

    public <T extends Enum<T> & OpcaoMenu> void menuEnums(T[] valores) {
        for (T valor : valores) {
            System.out.println("[" + valor.getId() +
                    "]" + " - "
                    + valor.getDescricao());
        }
    }

    public <T extends Enum<T> & OpcaoMenu> T lerEnumAteValido(T[] valores, Supplier<Optional<T>> leitor) {
        Optional<T> resultado = Optional.empty();
        while(resultado.isEmpty()) {
            menuEnums(valores);
            resultado = leitor.get();
            if(resultado.isEmpty()) System.out.println("Valor Inválido. Tente Novamente!");
        }
        return resultado.get();
    }

    public <T> T lerAteValido(Supplier<Optional<T>> leitor) {
        Optional<T> resultado = Optional.empty();
        while(resultado.isEmpty()) {
            resultado = leitor.get();
            if(resultado.isEmpty()) System.out.println("Valor Inválido. Tente Novamente!");
        }
        return resultado.get();
    }

    public Optional<UUID> selecionarDespesaDaLista() {
        List<Despesa> despesas = controller.listarDespesas();
        exibirDespesas(despesas);
        if(despesas.isEmpty()) { return Optional.empty(); }

        System.out.println("Selecione a despesa: (Digite o ID entre [])");
        int idLista;
        do {
            idLista = lerAteValido(inputReader::lerInt);
            if (idLista < 1 || idLista > despesas.size()) {
                System.out.println("Valor Inválido. Tente Novamente!");
            }
        } while(idLista < 1 || idLista > despesas.size());

        return Optional.of(despesas.get(idLista - 1).getId());
    }

    private DadosDespesa coletarDados() {
        System.out.println("Data da Despesa: (dd/MM/yyyy)");
        LocalDate data = lerAteValido(inputReader::lerLocalDate);
        System.out.println("Descrição da Despesa: ");
        String descricao = lerAteValido(inputReader::lerString);
        System.out.println("Valor da Despesa: ");
        BigDecimal valor = lerAteValido(inputReader::lerBigDecimal);
        System.out.println("Tipo de pagamento: (Digite o ID)");
        TipoPagamento pagamento = lerEnumAteValido(TipoPagamento.values(), inputReader::lerTipoPagamento);
        System.out.println("Categoria Despesa: (Digite o ID)");
        TipoDespesa tipo = lerEnumAteValido(TipoDespesa.values(), inputReader::lerTipoDespesa);
        System.out.println("Observação da Despesa: ");
        String obs = inputReader.lerString().orElse("");

        return new DadosDespesa(data, descricao, valor, pagamento, tipo, obs);
    }

    public void cadastroDespesa() {
        DadosDespesa dadosDespesa = coletarDados();

        try {
            Despesa despesaGerada = controller.cadastrarDespesa(dadosDespesa.data(), dadosDespesa.descricao(), dadosDespesa.valor(),
                    dadosDespesa.pagamento(), dadosDespesa.tipo(), dadosDespesa.obs());
            System.out.println("[VIEW]: Despesa cadastrada com sucesso! ID: " + despesaGerada.getId());
        } catch (IllegalArgumentException iae) {
            System.out.println("[VIEW]: ERRO! " + iae.getMessage());
        }
    }

    public void removerDespesa() {
        Optional<UUID> uuidSelecionado = selecionarDespesaDaLista();
        if (uuidSelecionado.isEmpty()) return;
        UUID uuidDespesa = uuidSelecionado.get();

        try {
            controller.deletarDespesa(uuidDespesa);
            System.out.println("[VIEW]: Despesa excluída com sucesso! ID: " + uuidDespesa);
        } catch (NoSuchElementException iae) {
            System.out.println("[VIEW]: ERRO! " + iae.getMessage());
        }
    }

    public void atualizarDespesa() {
        Optional<UUID> uuidSelecionado = selecionarDespesaDaLista();
        if (uuidSelecionado.isEmpty()) return;
        UUID uuidDespesa = uuidSelecionado.get();

        DadosDespesa dadosDespesa = coletarDados();

        try {
            controller.atualizarDespesa(uuidDespesa, dadosDespesa.data(), dadosDespesa.descricao(), dadosDespesa.valor(),
                    dadosDespesa.pagamento(), dadosDespesa.tipo(), dadosDespesa.obs());
            System.out.println("[VIEW]: Despesa atualizada com sucesso! ID: " + uuidDespesa);
        } catch (IllegalArgumentException | NoSuchElementException nse) {
            System.out.println("[VIEW]: ERRO! " + nse.getMessage());
        }
    }

    public void listarDespesas() {
        List<Despesa> despesas = controller.listarDespesas();
        exibirDespesas(despesas);
    }

    public void exibirDespesas(List<Despesa> despesas) {
        if (despesas.isEmpty()) {
            System.out.println("Nenhuma despesa cadastrada.");
            return;
        }
        System.out.println("=== Lista de despesas ===");
        System.out.println(" #  Data         Descrição");
        for(int i = 0; i < despesas.size(); i++) {
            System.out.println("[" + (i + 1) + "] " +
                    InputReader.FORMATO_DATA.format(despesas.get(i).getData()) +
                    "   " +
                    despesas.get(i).getDescricao());
        }
    }
}