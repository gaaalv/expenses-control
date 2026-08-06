package br.com.gaalv;

import br.com.gaalv.controller.Controller;
import br.com.gaalv.model.Despesa;
import br.com.gaalv.model.enums.TipoDespesa;
import br.com.gaalv.model.enums.TipoPagamento;
import br.com.gaalv.repository.Repository;
import br.com.gaalv.repository.impl.InMemoryRepository;
import br.com.gaalv.service.Service;
import br.com.gaalv.view.ConsoleView;
import br.com.gaalv.view.InputReader;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AppConfig {
    public static ConsoleView configurarAplicacao() {
        Repository repository = new InMemoryRepository();
        InputReader inputReader = new InputReader();

        Service service = new Service(repository);
        Controller controller = new Controller(service);

        Despesa d01 = new Despesa(LocalDate.of(2002, 1, 11), "Teste01",
                new BigDecimal("100"), TipoPagamento.CREDITO, TipoDespesa.ALIMENTACAO, "");

        Despesa d02 = new Despesa(LocalDate.of(2002, 1, 11), "Teste02",
                new BigDecimal("100"), TipoPagamento.CREDITO, TipoDespesa.ALIMENTACAO, "");

        Despesa d03 = new Despesa(LocalDate.of(2003, 1, 11), "Teste03",
                new BigDecimal("100"), TipoPagamento.CREDITO, TipoDespesa.ALIMENTACAO, "");

        repository.salvar(d01);
        repository.salvar(d02);
        repository.salvar(d03);

        return new ConsoleView(controller, inputReader);
    }
}
